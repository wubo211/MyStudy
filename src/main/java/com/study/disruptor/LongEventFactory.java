package com.study.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/12/26 15:35
 **/
public class LongEventFactory implements EventFactory<LongEvent> {


    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
