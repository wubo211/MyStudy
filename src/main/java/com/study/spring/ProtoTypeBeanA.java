package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @Description：
 * @Author： wub
 * @Date： 2019/11/18 15:22
 **/
@Service
@Scope("prototype")
public class ProtoTypeBeanA extends AbstarctProtoTypeBean{
    /*@Autowired
    TestBean1 testBean1;
    @Autowired
    TestBean2 testBean2;
    @Autowired
    TestBean3 testBean3;
    @Autowired
    TestBean4 testBean4;
    @Autowired
    TestBean5 testBean5;
    @Autowired
    TestBean6 testBean6;
    @Autowired
    TestBean7 testBean7;
    @Autowired
    TestBean8 testBean8;
    @Autowired
    TestBean9 testBean9;
    @Autowired
    TestBean10 testBean10;*/

    @Override
    public void print(){
        System.out.println("ProtoTypeBeanA I am a prototype bean");
    }
}
