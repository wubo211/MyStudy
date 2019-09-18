package com.study.concurrent.thread;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/17 19:46
 **/
@Component
public class PurchaseValidator {
    private ExecutorService executorService = new ThreadPoolExecutor(3,10,0L,
            TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(20),new MyThreadFactory());


    public void test() throws InterruptedException, ExecutionException {
        try {
            Random random = new Random();
            List<Integer> skuList = new ArrayList<>();
            for (int i= 0;i<3;i++){
                skuList.add(random.nextInt(10));
            }
            List<FutureTask<Boolean>> list = new ArrayList();
            for (Integer skuId : skuList){
                FutureTask<Boolean> task = new FutureTask<Boolean>(new FirstValidator(skuId));
                list.add(task);
                executorService.submit(task);
            }

            List<Boolean> results = new ArrayList<>();
            for (FutureTask<Boolean> task : list){
                Boolean integer = task.get();
                System.out.println("获取返回值:"+integer);
                results.add(integer);
            }


            System.out.println("结果数量:"+results.size());
            for (Boolean integer : results){
                System.out.println("结果:"+integer);
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        }finally {
            executorService.shutdown();
        }
    }


}
