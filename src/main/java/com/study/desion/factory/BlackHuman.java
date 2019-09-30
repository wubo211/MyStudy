package com.study.desion.factory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/29 15:56
 **/
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑色人种，肤色是黑色");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种，会说话");
    }
}
