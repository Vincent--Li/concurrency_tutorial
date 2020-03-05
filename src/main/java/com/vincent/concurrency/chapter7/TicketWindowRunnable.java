package com.vincent.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:27
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private final static int  MAX = 1000;

    private final Object MONITOR = new Object();

    @Override
    public void run() {

        while(true){

            synchronized (MONITOR){
                if(index > MAX){
                    break;
                }

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));

            }

        }
    }
}
