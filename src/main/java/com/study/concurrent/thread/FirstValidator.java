package com.study.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/17 19:51
 **/
public class FirstValidator implements Callable<Integer> {
    private final static Logger logger = LoggerFactory.getLogger(FirstValidator.class);
    @Override
    public Integer call() throws Exception {
        logger.info("{} 线程开始执行",Thread.currentThread().getName());
        Thread.sleep(1000);
        Random random = new Random();
        int i = random.nextInt(10);
        if (i < 5){
            throw new RuntimeException(Thread.currentThread().getName()+"抛出异常");
        }
        return i;
    }
}
