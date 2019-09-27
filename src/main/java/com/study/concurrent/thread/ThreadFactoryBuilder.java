package com.study.concurrent.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 15:21
 **/
public final class ThreadFactoryBuilder {
    private String namePrefix;
    private AtomicInteger threadNumber;

    public ThreadFactoryBuilder setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
        return this;
    }

    public ThreadFactoryBuilder setThreadNumber(AtomicInteger threadNumber) {
        this.threadNumber = threadNumber;
        return this;
    }

    public ThreadFactory build(){
        return build(this);
    }

    private static ThreadFactory build (ThreadFactoryBuilder builder){
        return r -> {
            Thread t = new Thread( r, builder.namePrefix + builder.threadNumber.getAndIncrement());
            if (t.isDaemon()){
                t.setDaemon(false);
            }

            if (t.getPriority() != Thread.NORM_PRIORITY){
                t.setPriority(Thread.NORM_PRIORITY);
            }

            return t;
        };
    }

}
