package com.study.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description：
 * @Author： wub
 * @Date： 2020/1/9 16:45
 **/
public class CglibTest {

    public void test(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before run");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("after run");
                return result;
            }
        });

        CglibTest proxyObject = (CglibTest)enhancer.create();
        proxyObject.test();
    }

}
