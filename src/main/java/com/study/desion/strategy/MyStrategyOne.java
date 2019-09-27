package com.study.desion.strategy;

import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/15 8:41
 **/
@Service
public class MyStrategyOne implements IMyStrategy{
    @Override
    public void doSomeThing() {
        System.out.println("策略1在执行");
    }

    @Override
    public String getKey() {
        return "one";
    }
}
