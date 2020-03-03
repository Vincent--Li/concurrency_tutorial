package com.vincent.concurrency.chapter2;

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

    private final static int MAX = 1000;

    public void run() {

        while(index <= MAX){
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
        }
    }
}
