package com.vincent.concurrency.chapter8;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 23:15
 */
public class OtherService {

    private final Object lock = new Object();

    private DeadLock deadLock;

    public void s1(){
        synchronized (lock){
            System.out.println("s1==================");
        }
    }

    public void s2(){
        synchronized (lock){
            System.out.println("s2==================");
            deadLock.m2();
        }
    }

    public void setDeadLock(DeadLock deadLock){
        this.deadLock = deadLock;
    }


}
