package com.study.zookeeper.configCenter;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:26 19/8/8
 **/

public class ZkConfigManager {
    private String nodePath = "/commConfig";
    private CommonConfig commonConfig;
    private ZkClient zkClient = new ZkClient("192.168.28.127:2181");

    public CommonConfig initConfig(CommonConfig commonConfig){
        if (commonConfig == null){
            this.commonConfig = new CommonConfig("myusername","mypassword");
        }else {
            this.commonConfig = commonConfig;
        }
        return this.commonConfig;
    }

    public CommonConfig update(CommonConfig commonConfig){
        if (commonConfig == null){
            return null;
        }
        this.commonConfig = commonConfig;

        synConfigToZk(commonConfig);
        return this.commonConfig;

    }

    public void synConfigToZk(CommonConfig commonConfig){
        if (!zkClient.exists(nodePath)){
            zkClient.createPersistent(nodePath);
        }
        zkClient.writeData(nodePath,commonConfig);
    }

    public static void main(String[] args) throws InterruptedException {
        ZkConfigManager zkConfigManager = new ZkConfigManager();
        CommonConfig commonConfig = zkConfigManager.initConfig(null);
        zkConfigManager.synConfigToZk(commonConfig);
        int count = 1;
        while (count < 10){
            TimeUnit.SECONDS.sleep(10);

            zkConfigManager.update(new CommonConfig("yourusername"+count,"yourpassword"+count));
            System.out.println("更新配置节点数据");
            count++;
        }
        }
}
