package com.study.desion.command;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/30 10:16
 **/
public class PageGroup implements Group {
    @Override
    public void add() {
        System.out.println("页面组,增加页面");
    }

    @Override
    public void del() {
        System.out.println("页面组，删除页面");
    }
}
