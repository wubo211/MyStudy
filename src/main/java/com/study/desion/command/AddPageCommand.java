package com.study.desion.command;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/30 10:22
 **/
public class AddPageCommand extends AbstractCommand {
    private Group pageGroup;

    public AddPageCommand() {
        this.pageGroup = new PageGroup();
    }

    public AddPageCommand(Group pageGroup) {
        this.pageGroup = pageGroup;
    }

    @Override
    public void execute() {
        pageGroup.add();
    }
}
