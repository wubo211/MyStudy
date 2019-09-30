package com.study.desion.factory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/29 15:55
 **/
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白色人种，肤色是白色");
    }

    @Override
    public void talk() {
        System.out.println("白色人种会说话");
    }
}
