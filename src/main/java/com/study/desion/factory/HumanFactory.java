package com.study.desion.factory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/29 16:02
 **/
public class HumanFactory extends AbstrackHumanFactory {
    @Override
    protected <T extends Human> T createHuman(Class<T> clazz) {
        T o = null;
        try {
            o = (T)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
