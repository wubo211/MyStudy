package com.study.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/17 19:51
 **/
public class FirstValidator implements Callable<Boolean> {
    private final static Logger logger = LoggerFactory.getLogger(FirstValidator.class);

    private int a;

    public FirstValidator(int a) {
        this.a = a;
    }

    @Override
    public Boolean call() throws Exception {
        logger.info("{} 线程开始执行",Thread.currentThread().getName());
        List<MyValidator> validators = ValidateContext.getValidators();
        ValidateRequest request = new ValidateRequest();
        request.setA(a);
        for (MyValidator validator : validators){
            boolean validate = validator.validate(request);
            if (!validate){
                return false;
            }
        }
        logger.info("{} 线程执行完成",Thread.currentThread().getName());
        return true;
    }
}
