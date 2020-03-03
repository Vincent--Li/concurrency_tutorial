package com.vincent.concurrency.chapter2;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:16
 */
public class TicketWindow extends Thread{

    private final String name;

    private static final int MAX = 1000;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while( index <= MAX){
            System.out.println(this.name + " 当前的号码是:" + (index++));
        }
    }
}
