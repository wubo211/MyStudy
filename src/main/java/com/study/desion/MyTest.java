package com.study.desion;

import com.study.desion.builder.Product;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/18 17:00
 **/
public class MyTest {
    public static void main(String[] args) {
        Product product1 = new Product.Builder().setId(123).setName("京东").setPrice(10000000).setType(123).build();
        System.out.println(product1.toString());
    }
}
