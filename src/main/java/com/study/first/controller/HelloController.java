package com.study.first.controller;

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

    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        System.out.println("hello 被调用");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","hello world");
        modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
        return modelAndView;
    }
}
