package com.study.concurrent.thread;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 14:19
 **/
@Component
public class ValidateContext implements ApplicationContextAware {
    private static List<MyValidator> validators = new ArrayList<>();

    public static List<MyValidator> getValidators() {
        return validators;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, MyValidator> beansOfType = applicationContext.getBeansOfType(MyValidator.class);
        validators.addAll(beansOfType.values());
    }
}
