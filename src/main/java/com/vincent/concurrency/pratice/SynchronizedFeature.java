package com.vincent.concurrency.pratice;

import java.util.concurrent.TimeUnit;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/14 21:38
 */
public class SynchronizedFeature {
    Object o = new Object();

    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedFeature t = new SynchronizedFeature();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(t::m, "t2");

//        t.o = new Object(); //锁对象发生改变, t2线程得以执行,如果注释掉这句话, t2永远得不到执行

        t2.start();
    }
}
