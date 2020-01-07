package com.study.disruptor;

import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/12/26 16:45
 **/
public class LongEvnetMain {
    public static void main(String[] args) {

        LongEventFactory factory = new LongEventFactory();

        int bufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory,bufferSize, DaemonThreadFactory.INSTANCE);
    }
}
