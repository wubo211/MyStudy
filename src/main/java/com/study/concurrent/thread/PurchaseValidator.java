package com.study.concurrent.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/17 19:46
 **/
public class PurchaseValidator {
    private ExecutorService executorService = new ThreadPoolExecutor(2,2,0L,
            TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1),new MyThreadFactory());

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public static void main(String[] args){
        System.out.println("开始..........");

        try {
            test();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException 异常111111");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException 异常111111");
        }
        System.out.println("结束..........");


    }

    public static void test() throws InterruptedException, ExecutionException {
        PurchaseValidator purchaseValidator = new PurchaseValidator();
        ExecutorService executorService = purchaseValidator.getExecutorService();

        try {
            System.out.println(Thread.currentThread().getName()+"开始");
            FutureTask<Integer> task1 = new FutureTask<Integer>(new FirstValidator());
            FutureTask<Integer> task2 = new FutureTask<Integer>(new FirstValidator());
            FutureTask<Integer> task3 = new FutureTask<Integer>(new FirstValidator());
            executorService.submit(task1);
            executorService.submit(task2);
            executorService.submit(task3);


            List<FutureTask<Integer>> list = new ArrayList();
            list.add(task1);
            list.add(task2);
            list.add(task3);
            List<Integer> results = new ArrayList<>();
            for (FutureTask<Integer> task : list){
                try {
                    results.add(task.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }


            for (Integer integer : results){
                System.out.println("结果:"+integer);
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        }finally {
            executorService.shutdown();
        }
    }


}
