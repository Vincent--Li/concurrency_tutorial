package com.vincent.concurrency.pratice;

import java.util.concurrent.TimeUnit;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/13 15:57
 *
 *
 */

public class Account {
    // 演示脏读, 多线程写数据的时候, 读取数据的操作容易产生脏读
    // 解决方案, 读取操作也加synchronized

    String name;
    double balance;

    public synchronized void set(String name, double balance){
        this.name = name;

        //这一段是关键, 长时间操作容易引起这种情况
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public synchronized double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->{
            a.set("zhangsan", 100.0);
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));


    }
}
