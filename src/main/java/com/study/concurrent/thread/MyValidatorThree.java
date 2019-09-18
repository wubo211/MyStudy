package com.study.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 14:15
 **/
@Service
public class MyValidatorThree implements MyValidator {
    private static final Logger logger = LoggerFactory.getLogger(MyValidatorThree.class);
    @Override
    public boolean validate(ValidateRequest request) {
        logger.info("{} --> 开始校验,request:{}",this.getClass().getSimpleName(),request.getA());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
