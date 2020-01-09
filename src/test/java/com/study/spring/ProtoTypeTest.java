package com.study.spring;

import com.study.spring.aop.Son;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/12/9 17:25
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class ProtoTypeTest {

    @Autowired
    SingletonBeanA singletonBean;

    @Autowired
    private Son son;

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        for (int i = 0 ;i<10000;i++){
            singletonBean.say();
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }

    @Test
    public void aspect(){
        son.doHomeWork("math");
    }

}
