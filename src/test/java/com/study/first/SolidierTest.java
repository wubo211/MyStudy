package com.study.first;

import com.study.redis.RedisUtil;
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

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void killPeople() {
        solidier.killPeople();
    }

    @Test
    public void testRedis(){
        String blackStringTest = redisUtil.set("blackStringTest", "");
        String s = redisUtil.get("blackStringTest");

        System.out.println(s);
        System.out.println(s==null);
        System.out.println(s.equals(""));
        redisUtil.del("blackStringTest");
        String blackStringTest1 = redisUtil.get("blackStringTest");
        System.out.println(blackStringTest1);


    }
}