package com.study.spring.aop.impl;

import com.study.spring.aop.Son;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author： wub
 * @Date： 2020/1/9 11:02
 **/
@Component
public class SonYiYi implements Son {

    @Autowired
    private Son son;
    @Override
    public void watchTv() {
        System.out.println("yiyi watching TV");
    }

    @Override
    public String doHomeWork(String className) {
        son.watchTv();
        System.out.println("yiyi doing " + className + " home work");
        return "home work done";
    }

    @Override
    public void playGames() {
        System.out.println("yiyi playing games");
    }
}
