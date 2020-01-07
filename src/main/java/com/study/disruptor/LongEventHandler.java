package com.study.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/12/26 15:40
 **/
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("Event:"+longEvent.getValue());
    }
}
