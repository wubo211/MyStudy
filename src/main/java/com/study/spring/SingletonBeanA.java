package com.study.spring;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/11/18 15:23
 **/
@Component
public abstract class SingletonBeanA {

    @Lookup
    public abstract IProtoTypeBean getBean();

    public void say(){
        IProtoTypeBean bean = getBean();
        bean.print();
    }
}
