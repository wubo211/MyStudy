package com.study.desion.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/15 8:45
 **/
@Component
public class MyStrategyContext implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(MyStrategyContext.class);

    private static Map<String,IMyStrategy> MAPPING = new HashMap<>();


    public void doSomeThing(String key){
        MAPPING.get(key).doSomeThing();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IMyStrategy> beansOfType = applicationContext.getBeansOfType(IMyStrategy.class);
        for (String key : beansOfType.keySet()){
            logger.info("MyStrategyContext -> setApplicationContext beansOfType key:{},value:{}",key,beansOfType.get(key));
        }
        Collection<IMyStrategy> values = beansOfType.values();
        if (values != null && values.size()>0){
            for (IMyStrategy iMyStrategy : values){
                MAPPING.put(iMyStrategy.getKey(),iMyStrategy);
            }
        }
        for (String key : MAPPING.keySet()){
            logger.info("MyStrategyContext -> setApplicationContext mapping key:{},value:{}",key,MAPPING.get(key));
        }
    }
}
