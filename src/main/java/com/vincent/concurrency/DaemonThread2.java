package com.vincent.concurrency;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 8:37
 */
public class DaemonThread2 {

    public static void main(String[] args) {

        Thread t = new Thread(()->{
            Thread innerThread = new Thread(()->{
                try {
                    Thread.sleep(100_000);
                    System.out.println("innerThread thread finish done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("T thread finish done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
    }
}
