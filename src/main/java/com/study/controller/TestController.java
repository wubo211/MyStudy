package com.study.controller;

import com.study.desion.strategy.IMyStrategy;
import com.study.desion.strategy.MyStrategyContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/8/15 8:46
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private MyStrategyContext myStrategyContext;


    @RequestMapping("/myStrategyOne")
    public void myStrategyOneTest() throws InterruptedException {
        logger.info("myStrategyOneTest start");
        myStrategyContext.doSomeThing("one");

        TimeUnit.SECONDS.sleep(10);

        myStrategyContext.doSomeThing("one");
        logger.info("myStrategyOneTest end");
    }

    @RequestMapping("/myStrategyTwo")
    public void myStrategyTwoTest() throws InterruptedException {
        logger.info("myStrategyTwoTest start");
        myStrategyContext.doSomeThing("two");

        TimeUnit.SECONDS.sleep(10);

        myStrategyContext.doSomeThing("two");
        logger.info("myStrategyTwoTest end");
    }
}
