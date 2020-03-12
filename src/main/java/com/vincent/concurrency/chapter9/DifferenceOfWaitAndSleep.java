package com.vincent.concurrency.chapter9;

import java.util.stream.Stream;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/12 17:26
 */
public class DifferenceOfWaitAndSleep {
    /**
     *
     1. sleep是Thread的一个方法, wait是Object的一个方法
     2. sleep不会释放Object monitor lock, wait会释放monitor并且将自身加入Object monitor的等待队列
     3. sleep的方法不依赖monitor, 但是wait需要依赖唤醒; 意味着sleep不需要synchronized, wait一定是配合synchronized使用
     4. sleep可以自己恢复, 不需要额外的唤醒; 但是wait需要被notify( wait(0), 带参数的出外)
     */

    private final static Object LOCK = new Object();

    public static void main(String[] args){
//        m1();
//        m2();
        Stream.of("T1", "T2").forEach(n ->
                new Thread(){
                    @Override
                    public void run() {
                        m2();
                    }
                }.start());
    }

    public static void m1(){
        synchronized (LOCK){
            try {
                System.out.println("The thread" + Thread.currentThread().getName() + "entered");
                Thread.sleep(2000);
                System.out.println("The thread" + Thread.currentThread().getName() + "exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

//    public static void m2(){
//        //这样会报错, IllegalMonitorStateException
//        try {
//            LOCK.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    public static void m2(){
        synchronized (LOCK){
            try {
                System.out.println("The thread" + Thread.currentThread().getName() + "entered");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
