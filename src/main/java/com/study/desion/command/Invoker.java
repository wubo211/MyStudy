package com.study.desion.command;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/30 10:27
 **/
public class Invoker {

    public void action(Command command){
        command.execute();
    }
}
