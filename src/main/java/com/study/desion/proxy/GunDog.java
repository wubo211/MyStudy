package com.study.desion.proxy;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午11:22 19/9/26
 **/

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("这是一条猎狗");
    }

    @Override
    public void run() {
        System.out.println("猎狗跑的很快");
    }
}
