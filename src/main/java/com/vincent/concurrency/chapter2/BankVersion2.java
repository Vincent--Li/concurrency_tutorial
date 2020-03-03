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

    private final static int MAX = 1000;

    public static void main(String[] args) {


//        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();

        final Runnable ticketWindow = ()->{
            int index = 1;
            while(index <= MAX){
                while( index <= MAX){
                    System.out.println(Thread.currentThread() + " 当前的号码是:" + (index++));
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        };


        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
