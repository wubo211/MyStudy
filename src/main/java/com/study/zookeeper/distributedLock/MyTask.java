package com.study.zookeeper.distributedLock;

import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/21 20:12
 **/
public class MyTask implements Runnable {
    @Override
    public void run() {
        DistributedLock lock = new DistributedLock();
        String lockName = lock.getLock();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (lockName != null){
            lock.releaseLock(lockName);
        }
        lock.closeZkClient();
    }
}
