package com.study.desion.command;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/30 10:27
 **/
public class Client {
    public static void main(String[] args) {
        Command command = new AddPageCommand();
        Command command1 = new DelPageCommand();
        Invoker invoker = new Invoker();
        invoker.action(command);
        invoker.action(command1);

        invoker.action(() -> {
            Group group = new PageGroup();
            group.add();
        });
    }
}
