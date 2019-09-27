package com.study.desion;

import com.study.desion.builder.Product;
import com.study.desion.proxy.Dog;
import com.study.desion.proxy.GunDog;
import com.study.desion.proxy.MyInvocationHandler;
import com.study.desion.proxy.ProxyDog;

import java.lang.reflect.Proxy;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 17:00
 **/
public class MyTest {
    public static void main(String[] args) {
        Dog gunDog = new GunDog();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(gunDog);
        Dog dog = (Dog)Proxy.newProxyInstance(gunDog.getClass().getClassLoader(), new Class[]{Dog.class}, invocationHandler);
        dog.info();
        dog.run();
        Dog proxyDog = new ProxyDog(gunDog);
        proxyDog.info();
        proxyDog.run();

    }
}
