package com.study.desion.command;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/30 10:25
 **/
public class DelPageCommand extends AbstractCommand {

    private Group pageGroup;

    public DelPageCommand() {
        this.pageGroup = new PageGroup();
    }

    @Override
    public void execute() {
        this.pageGroup.del();
    }
}
