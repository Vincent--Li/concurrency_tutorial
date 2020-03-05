package com.vincent.concurrency.chapter7;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 22:10
 */
public class SynchronizedTest {

    private final static Object LOCK = new Object();

    public static void main(String[] args) {

        //使用jconsole查看线程

        Runnable runnable = ()->{
            synchronized (LOCK){
                try {
                    Thread.sleep(300_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();


    }
}
