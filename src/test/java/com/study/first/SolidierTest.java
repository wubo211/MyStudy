package com.study.first;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:25 19/5/29
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class SolidierTest {
    @Autowired
    private ISolidier solidier;

    @Test
    public void killPeople() {
        solidier.killPeople();
    }
}