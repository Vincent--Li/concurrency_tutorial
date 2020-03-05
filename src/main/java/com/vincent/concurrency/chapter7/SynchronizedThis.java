package com.vincent.concurrency.chapter7;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 22:55
 */
public class SynchronizedThis {

    public static void main(String[] args) {

        //验证方法级别的synchronized是锁this对象的.
        // 如果m1和m2都是synchronized, 并且锁this, 一定会有先后顺序

        ThisLock thisLock = new ThisLock();
        new Thread("T1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();
        new Thread("T2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();


    }
}

class ThisLock {

    private final Object LOCK = new Object();

    public synchronized void m1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void m2(){
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
