package com.study.desion.command;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/30 10:17
 **/
public class CodeGroup implements Group {
    @Override
    public void add() {
        System.out.println("代码组，增加代码");
    }

    @Override
    public void del() {
        System.out.println("代码组，删除代码");
    }
}
