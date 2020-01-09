package com.study.desion.proxy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.Proxy;


/**
 * @Description：
 * @Author： wub
 * @Date： 2020/1/9 15:53
 **/
public class ProxyTest {

    @Test
    public void proxy(){
        Dog dog = new GunDog();

        MyInvocationHandler invocationHandler = new MyInvocationHandler(dog);

        Dog proxyDog = (Dog)Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), invocationHandler);

        System.out.println(proxyDog.getClass().getName());
        System.out.println(JSON.toJSONString(proxyDog.getClass().getDeclaredMethods()));
        proxyDog.info();
        proxyDog.run();
    }
}