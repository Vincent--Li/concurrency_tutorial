package com.vincent.concurrency.chapter8;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 23:14
 */
public class DeadLock {

    private OtherService otherService = new OtherService();

    private final Object lock = new Object();

    public  DeadLock(OtherService otherService){
        this.otherService = otherService;
    }

    public void m1(){
        synchronized (lock){
            System.out.println("m1===========");

            otherService.s1();
        }

    }

    public void m2(){
        synchronized (lock){
            System.out.println("m2===========");
        }

    }
}
