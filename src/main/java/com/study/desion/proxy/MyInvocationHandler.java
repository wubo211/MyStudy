package com.study.desion.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午11:23 19/9/26
 **/

public class MyInvocationHandler implements InvocationHandler {
    private Object _object;

    public MyInvocationHandler(Object _object) {
        this._object = _object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(_object,args);
        after();
        return null;
    }

    private void before(){
        System.out.println("前置方法");
    }

    private void after(){
        System.out.println("后置方法");
    }
}
