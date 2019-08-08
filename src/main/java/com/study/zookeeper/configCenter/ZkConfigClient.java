package com.study.zookeeper.configCenter;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:42 19/8/8
 **/

public class ZkConfigClient implements Runnable
{
    private String nodePath = "/commConfig";
    private CommonConfig commonConfig;
    private ZkClient zkClient = new ZkClient("127.0.0.1:2181");
    @Override
    public void run() {
        while (!zkClient.exists(nodePath)){
            System.out.println("配置节点不存在");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.commonConfig = (CommonConfig)zkClient.readData(nodePath);
        System.out.println(commonConfig.toString());
        zkClient.subscribeDataChanges(nodePath, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                if (s.equals(nodePath)){
                    System.out.println("节点:"+nodePath+",数据更新:"+o.toString());
                    commonConfig = (CommonConfig) o;
                }
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (s.equals(nodePath)){
                    System.out.println("节点:"+nodePath+",被删除了");
                }
            }
        });

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new ZkConfigClient());
        executorService.submit(new ZkConfigClient());
        executorService.submit(new ZkConfigClient());
    }
}
