package com.study.desion.factory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/9/29 16:05
 **/
public class Client {
    public static void main(String[] args) {
        //HumanFactory factory = new HumanFactory();

        YellowHuman human = SimpleHumanFactory.createHuman(YellowHuman.class);
        human.getColor();
        human.talk();
        WhiteHuman human1 = SimpleHumanFactory.createHuman(WhiteHuman.class);
        human1.getColor();
        human1.talk();
        BlackHuman human2 = SimpleHumanFactory.createHuman(BlackHuman.class);
        human2.getColor();
        human2.talk();
    }
}
