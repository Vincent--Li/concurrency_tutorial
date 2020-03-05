package com.vincent.concurrency.chapter8;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 23:20
 */
public class DeadLockTest {
    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);

        new Thread(){
            @Override
            public void run() {
                while(true){
                    deadLock.m1();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    otherService.s2();
                }
            }
        }.start();

    }
}
