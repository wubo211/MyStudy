package com.study.spring;

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
    SingletonBean singletonBean;

    @Test
    public void test(){
        for (int i = 0 ;i<10;i++){
            String name = singletonBean.getClass().getName();
            System.out.println("Singleton bean name:"+name);
            System.out.println("Singleton bean hashCode:"+singletonBean.hashCode());
            singletonBean.say();

        }

    }

}
