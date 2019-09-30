package com.study.desion.command;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/30 10:15
 **/
public class RequirementGroup implements Group {
    @Override
    public void add() {
        System.out.println("需求组，新增需求");
    }

    @Override
    public void del() {
        System.out.println("需求组，删除需求");
    }
}
