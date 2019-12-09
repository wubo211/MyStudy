package com.study.spring;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/11/18 15:23
 **/
@Component
public abstract class SingletonBean {

    @Lookup
    public abstract IProtoTypeBean getBean();

    public void say(){
        IProtoTypeBean bean = getBean();
        System.out.println("protoType bean name:"+bean.getClass().getName());
        System.out.println("protoType bean hashCode:"+bean.hashCode());
        bean.print();
    }
}
