package com.study.concurrent.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:01 19/9/17
 **/

public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runnable task = new FirstTask(3,2);
        executorService.execute(task);
        System.out.println("main 结束");
        executorService.shutdown();


    }
}
