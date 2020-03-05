package com.vincent.concurrency.chapter7;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:29
 */
public class BankVersion3 {


    public static void main(String[] args) {


        final SychronizedRunnable sychronizedRunnable = new SychronizedRunnable();

        Thread windowThread1 = new Thread(sychronizedRunnable, "一号窗口");
        Thread windowThread2 = new Thread(sychronizedRunnable, "二号窗口");
        Thread windowThread3 = new Thread(sychronizedRunnable, "三号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
