package com.study.spring.aop.impl;

import com.study.spring.aop.Son;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author： wub
 * @Date： 2020/1/9 11:02
 **/
@Component
public class SonYiYi implements Son {
    @Override
    public void watchTv() {
        System.out.println("yiyi watching TV");
    }

    @Override
    public String doHomeWork(String className) {
        System.out.println("yiyi doing " + className + " home work");
        return "home work done";
    }

    @Override
    public void playGames() {
        System.out.println("yiyi playing games");
    }
}
