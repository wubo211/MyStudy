package com.study.desion.strategy;

import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/15 8:43
 **/
@Service
public class MyStrategyTwo implements IMyStrategy {
    @Override
    public void doSomeThing() {
        System.out.println("策略2在执行");
    }

    @Override
    public String getKey() {
        return "two";
    }
}
