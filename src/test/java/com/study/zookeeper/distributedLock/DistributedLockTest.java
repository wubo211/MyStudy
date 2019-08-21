package com.study.zookeeper.distributedLock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/21 20:07
 **/
public class DistributedLockTest {

    @Test
    public void getLock() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0 ;i<10;i++){
            executorService.submit(new MyTask());
        }
    }
}