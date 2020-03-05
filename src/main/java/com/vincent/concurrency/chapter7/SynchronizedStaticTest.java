package com.vincent.concurrency.chapter7;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 23:04
 */
public class SynchronizedStaticTest {

    public static void main(String[] args) {

        new Thread("T1"){
            @Override
            public void run() {
                SynchronizedStatic.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                SynchronizedStatic.m2();
            }
        }.start();
    }
}
