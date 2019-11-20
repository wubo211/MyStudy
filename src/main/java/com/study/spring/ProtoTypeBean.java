package com.study.spring;

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
public class ProtoTypeBean extends AbstarctProtoTypeBean{
    @Override
    public void print(){
        System.out.println("I am a prototype bean");
    }
}
