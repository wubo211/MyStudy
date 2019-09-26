package com.study.desion.proxy;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午11:54 19/9/26
 **/

public class ProxyDog implements Dog {

    private Dog dog;

    public ProxyDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void info() {
        before();
        this.dog.info();
        after();
    }

    @Override
    public void run() {
        before();
        this.dog.run();
        after();
    }

    private void before(){
        System.out.println("前置方法");
    }

    private void after(){
        System.out.println("后置方法");
    }
}
