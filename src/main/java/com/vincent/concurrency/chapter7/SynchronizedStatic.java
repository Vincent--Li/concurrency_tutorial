package com.vincent.concurrency.chapter7;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 23:02
 */
public class SynchronizedStatic {

    static {
        //静态代码块, 中的锁是Class
        //为了证明其它两个方法, 锁的是SynchronizedStatic
        synchronized (SynchronizedStatic.class){
            System.out.println("static " + Thread.currentThread().getName());

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void m1() {

        System.out.println("M1 " + Thread.currentThread().getName());

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m2() {

        System.out.println("M2 " + Thread.currentThread().getName());

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
