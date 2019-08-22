package com.study.zookeeper.distributedLock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/21 17:19
 **/
public class DistributedLock {
    private ZkClient zkClient;

    private static final String LOCK_NODE = "/distributed_lock";
    private static final String CHILDREN_NODE = "/task_";

    public DistributedLock() {
        zkClient = new ZkClient("192.168.28.127:2181");
        /*if (!zkClient.exists(LOCK_NODE)){
            zkClient.create(LOCK_NODE,"分布式锁节点", CreateMode.PERSISTENT);
        }*/
    }

    public String getLock(){
        String lockName = zkClient.createEphemeralSequential(LOCK_NODE + CHILDREN_NODE, "");
        System.out.println(Thread.currentThread().getName()+"创建临时节点:"+lockName);
        acquireLock(lockName);
        return lockName;
    }


    public Boolean acquireLock(String lockName){
        List<String> children = zkClient.getChildren(LOCK_NODE);
        //System.out.println(Thread.currentThread().getName()+"获取所有子节点:"+children);
        Collections.sort(children, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split("_")[1]) - Integer.parseInt(o2.split("_")[1]);
            }
        });

        int lockPostion = children.indexOf(lockName.split("/")[lockName.split("/").length - 1]);
        //System.out.println(Thread.currentThread().getName()+"获取所有子节点:"+children);
        if (lockPostion < 0 ){
            //System.out.println(Thread.currentThread().getName()+"节点不存在:"+lockName);
            getLock();
        }else if (lockPostion == 0){
            System.out.println(Thread.currentThread().getName()+"获取锁:"+lockName);
            return true;
        }else if (lockPostion > 0){
            //System.out.println(Thread.currentThread().getName()+"未获取到锁，等待:"+lockName);

            final CountDownLatch latch = new CountDownLatch(1);

            IZkDataListener listener = new IZkDataListener() {
                @Override
                public void handleDataChange(String s, Object o) throws Exception {

                }

                @Override
                public void handleDataDeleted(String s) throws Exception {
                    System.out.println(Thread.currentThread().getName()+"前一个节点:["+s+"]被删除");
                    acquireLock(lockName);
                    latch.countDown();
                }
            };

            try {
                zkClient.subscribeDataChanges(LOCK_NODE+"/"+children.get(lockPostion - 1),listener);
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                zkClient.unsubscribeDataChanges(LOCK_NODE+"/"+children.get(lockPostion - 1),listener);
            }


        }
        return false;
    }

    public void releaseLock(String lockName){
        zkClient.delete(lockName);
    }

    public void closeZkClient(){
        zkClient.close();
    }
}
