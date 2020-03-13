package com.vincent.concurrency.pratice;

import java.util.concurrent.TimeUnit;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/13 16:34
 */
public class T3 {
    /*程序执行过程中, 如果出现异常, 默认情况锁会被释放
     因此, 并发处理过程中, 有异常要多加小心, 不然可能发生不一致的情况
     比如, 在一个web app中处理过程中, 多个servlet线程共同访问同一个资源, 这是如果异常处理不合适
     在第一个线程中抛出异常, 其它线程就会进入同步代码区, 有可能会访问到异常产生时的数据
     因此要非常小心的处理同步业务逻辑中的异常
     */

    int count = 0 ;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName() + " start");
        while (true){
            count ++;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count == 5){
                try{
                    int i = 1/0; //此处抛出异常, 锁将被释放, 想要不被释放, 可以在这里进行catch, 然后让循环继续
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                t3.m();
            }
        };
        new Thread(runnable, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //如果t1不抛出异常, t2永远不会执行

        new Thread(runnable, "t2").start();

    }
}
