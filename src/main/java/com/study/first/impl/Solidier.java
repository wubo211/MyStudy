package com.study.first.impl;

import com.study.first.IGun;
import com.study.first.ISolidier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:13 19/5/29
 **/
@Component
public class Solidier implements ISolidier {

    @Autowired
    private IGun gun;

    @Override
    public void killPeople() {
        System.out.println("士兵用"+gun.getName()+"杀人");
    }
}
