package com.study.desion.factory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/29 15:57
 **/
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色人种，肤色是黄色");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种，会说话");
    }
}
