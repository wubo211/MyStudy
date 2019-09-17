package com.study.concurrent.thread;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:42 19/9/17
 **/

public class FirstTask implements Runnable {

    private int a;
    private int b;

    public FirstTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " : " + (a+b));
        if ((a+b) == 5){
             a = 5/0;
        }
    }
}
