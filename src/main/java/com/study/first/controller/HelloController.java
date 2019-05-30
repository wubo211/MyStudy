package com.study.first.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:43 19/5/30
 **/
@Controller
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        logger.info("hello 被调用");
        logger.debug("debug 生效");
        logger.error("error 生效");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","hello world");
        modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
        return modelAndView;
    }
}
