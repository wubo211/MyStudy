package com.study.desion.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created on 2019/9/27
 */
public class MyProxy implements Dog {
    private InvocationHandler handler;
    public MyProxy(InvocationHandler _handler) {
        this.handler=_handler;
    }
    private static Method m1;
    private static Method m2;
    static {
        try {
            m1= Class.forName("com.study.desion.proxy.Dog").getMethod("info");
            m2=Class.forName("com.study.desion.proxy.Dog").getMethod("run");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }
    @Override
    public void info() {
        try {
            handler.invoke(this,m1,new Object[]{});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            handler.invoke(this,m2,new Object[]{});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
