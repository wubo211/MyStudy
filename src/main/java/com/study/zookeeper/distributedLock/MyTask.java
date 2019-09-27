package com.study.zookeeper.distributedLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/21 20:12
 **/
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行任务");
        for (int i = 0 ;i<10;i++){
            DistributedLock lock = new DistributedLock();
            String lockName = lock.getLock();
            try {
                Random random = new Random();
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (lockName != null){
                lock.releaseLock(lockName);
            }
            lock.closeZkClient();
        }

    }
}
