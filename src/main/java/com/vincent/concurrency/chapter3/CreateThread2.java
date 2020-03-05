package com.vincent.concurrency.chapter3;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 11:46
 */
public class CreateThread2 {

    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getThreadGroup());
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());

    }
}
