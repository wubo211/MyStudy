package com.study.concurrent.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/22 14:49
 **/
public class Producter implements Runnable {
    @Override
    public void run() {
        for (int i = 0 ;i < 100 ;i++){
            try {
                MyBlockingQueue.queue.enqueue(MyBlockingQueue.count.getAndIncrement());
                Random random = new Random();
                TimeUnit.SECONDS.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
