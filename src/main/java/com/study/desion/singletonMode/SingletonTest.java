package com.study.desion.singletonMode;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:44 19/6/25
 **/

public class SingletonTest {
    public static void main(String[] args) {
        SingletonClass instance = SingletonClass.getInstance();
        instance.doSomeThing();

    }
}
