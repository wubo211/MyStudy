package com.study.concurrent.thread;

import java.util.concurrent.*;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/17 19:46
 **/
public class PurchaseValidator {
    private ExecutorService executorService = new ThreadPoolExecutor(5,20,0L,
            TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10),new MyThreadFactory());

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PurchaseValidator purchaseValidator = new PurchaseValidator();
        ExecutorService executorService = purchaseValidator.getExecutorService();
        FutureTask<Integer> task1 = new FutureTask<Integer>(new FirstValidator());
        Future<?> submit = executorService.submit(task1);
        Integer integer = task1.get();
        System.out.println("结果:"+integer);


    }

}
