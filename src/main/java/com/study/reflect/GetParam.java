package com.study.reflect;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Method;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/12/4 15:18
 **/
public class GetParam {
    public static void main(String[] args) {

        Param request = new Param(1L, "TEST", "object");
        String json = JSONObject.toJSONString(request);
        System.out.println("json --> " + json);

        try {
            Method method = Class.forName("com.study.reflect.InterFaceTest").getMethod("test", Class.forName("com.study.reflect.Param"));
            System.out.println("method --> " + method);

            Class<?> paramClass = Class.forName("com.study.reflect.Param");
            System.out.println("paramClass --> " + paramClass);

            Object param = JSONObject.parseObject(json, paramClass);
            System.out.println("param --> " + param);

            method.invoke(Class.forName("com.study.reflect.InterFaceTest").newInstance(),param);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class InterFaceTest {

    public void test(Param param) {
        System.out.println("param test");
    }
}

class Param {

    Long id;

    String vale;

    Object o;

    public Param() {
    }

    public Param(Long id, String vale, Object o) {
        this.id = id;
        this.vale = vale;
        this.o = o;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVale() {
        return vale;
    }

    public void setVale(String vale) {
        this.vale = vale;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
}
