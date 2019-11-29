package com.study.desion;

import com.study.desion.builder.Product;
import com.study.desion.proxy.Dog;
import com.study.desion.proxy.GunDog;
import com.study.desion.proxy.MyInvocationHandler;
import com.study.desion.proxy.ProxyDog;
import com.study.first.Car;
import com.study.first.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 17:00
 **/
public class MyTest {

    private static Logger logger = LoggerFactory.getLogger(MyTest.class);
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("a",null);
        System.out.println(map.get("a"));

    }



    public static Set<Byte> getSupportPayType(Set<Byte> supportPaymentType, Set<Byte> postPayType) {
        Set<Byte> resultSet = new HashSet<Byte>();
        resultSet.addAll(supportPaymentType);
        logger.info("resultSet is {},postPayType is {},supportPaymentType is {}", resultSet, postPayType, supportPaymentType);
        resultSet.retainAll(postPayType);
        logger.info("resultSet is {}", resultSet);

        return resultSet;
    }
}
