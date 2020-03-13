package com.vincent.concurrency.pratice;

import java.util.concurrent.TimeUnit;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/13 16:26
 */
public class T2 {
    // synchronized 锁是可重入的. 意味着, 一个同步方法可以调用另一个同步方法
    // 子类同步方法, 调用父类同步方法. 是可以的
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    synchronized void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {

    }
}
