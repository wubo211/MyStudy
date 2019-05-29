package com.study.first.impl;

import com.study.first.IGun;
import org.springframework.stereotype.Component;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:21 19/5/29
 **/
@Component
public class BigGun implements IGun {
    @Override
    public void shoot() {
        System.out.println("射击");
    }

    @Override
    public String getName() {
        return "大枪";
    }
}
