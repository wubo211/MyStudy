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
    private String clientName;
    private String nodePath = "/commConfig";
    private CommonConfig commonConfig;
    private ZkClient zkClient = new ZkClient("192.168.28.127:2181");

    public ZkConfigClient() {
    }

    public ZkConfigClient(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void run() {
        while (!zkClient.exists(nodePath)){
            System.out.println(clientName+":配置节点不存在");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.commonConfig = (CommonConfig)zkClient.readData(nodePath);
        System.out.println(clientName+":"+commonConfig.toString());
        zkClient.subscribeDataChanges(nodePath, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                if (s.equals(nodePath)){
                    System.out.println(clientName+":节点:"+nodePath+",数据更新:"+o.toString());
                    commonConfig = (CommonConfig) o;
                }
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (s.equals(nodePath)){
                    System.out.println(clientName+":节点:"+nodePath+",被删除了");
                }
            }
        });

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new ZkConfigClient("客户端1"));
        executorService.submit(new ZkConfigClient("客户端2"));
        executorService.submit(new ZkConfigClient("客户端3"));
    }
}
