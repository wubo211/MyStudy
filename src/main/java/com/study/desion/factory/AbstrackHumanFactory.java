package com.study.desion.factory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/29 15:59
 **/
public abstract class AbstrackHumanFactory {
    protected abstract <T extends Human> T createHuman(Class<T> clazz);
}
