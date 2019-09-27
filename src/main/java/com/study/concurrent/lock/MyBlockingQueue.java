package com.study.concurrent.lock;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description： 阻塞队列
 * @Author： wub
 * @Date： 2019/8/22 14:25
 **/

public class MyBlockingQueue<E> {

    public static MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);

    public static AtomicInteger count = new AtomicInteger(0);

    int size = 10;
    ReentrantLock lock = new ReentrantLock();

    LinkedList<E> list = new LinkedList<>();

    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public MyBlockingQueue() {
    }

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            if (list.size() == size){
                System.out.println(Thread.currentThread().getName()+"队列已满:"+e);
                notFull.await();
            }
            list.add(e);
            System.out.println(Thread.currentThread().getName()+"入队:"+e);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            if (list.size() == 0){
                System.out.println(Thread.currentThread().getName()+"队列空了");
                notEmpty.await();
            }
            e = list.removeFirst();
            System.out.println(Thread.currentThread().getName()+"出队:"+e);
            notFull.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Producter());
        executorService.execute(new Producter());
        executorService.execute(new Producter());
        executorService.execute(new Producter());
        executorService.execute(new Producter());
        executorService.execute(new Consumer());
        executorService.execute(new Consumer());
        executorService.execute(new Consumer());
        executorService.execute(new Consumer());
        executorService.execute(new Consumer());
    }
}
