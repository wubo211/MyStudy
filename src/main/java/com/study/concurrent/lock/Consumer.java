package com.study.concurrent.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/22 14:56
 **/
public class Consumer implements Runnable {
    @Override
    public void run() {
        for (int i = 0 ;i < 100 ;i++){
            try {
                Integer dequeue = MyBlockingQueue.queue.dequeue();
                Random random = new Random();
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
