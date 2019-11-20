package com.study.concurrent.thread;

import com.study.spring.SingletonBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;


/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 14:36
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-context.xml"})
public class PurchaseValidatorTest {

    @Autowired
    private PurchaseValidator purchaseValidator;

    @Autowired
    private SingletonBean singletonBean;

    @Test
    public void testThread() {
        System.out.println("开始..........");

        try {
            purchaseValidator.test();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException 异常111111");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException 异常111111");
        }
        System.out.println("结束..........");
    }

    @Test
    public void protoTypeTest(){
        for (int i = 0 ;i< 5;i++){
            singletonBean.say();
        }

    }
}