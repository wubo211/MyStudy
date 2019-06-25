package com.study.desion.singletonMode;

/**
 * @Author: wubo
 * @Description: 饿汉式单例模式
 * @Date Created in 下午10:41 19/6/25
 **/

public class SingletonClass {
    private static SingletonClass ourInstance = new SingletonClass();

    public static SingletonClass getInstance() {
        return ourInstance;
    }

    private SingletonClass() {
    }

    public void doSomeThing(){
        System.out.println("饿汉式单例模式");
    }
}
