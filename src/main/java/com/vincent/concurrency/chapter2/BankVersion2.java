package com.vincent.concurrency.chapter2;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:29
 */
public class BankVersion2 {

    public static void main(String[] args) {

        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
