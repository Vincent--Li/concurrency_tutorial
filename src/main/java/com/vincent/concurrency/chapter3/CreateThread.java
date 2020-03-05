package com.vincent.concurrency.chapter3;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 11:28
 */
public class CreateThread {

    public static void main(String[] args) {
        Thread t = new Thread();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("===========");
            }
        };
        t.start();
        t1.start();
        System.out.println(t.getName());
        System.out.println(t1.getName());

        Thread t3 = new Thread("MyName");
        Thread t4 = new Thread(()->{
           System.out.println("Runnable .......");
        });
        System.out.println(t3.getName());
        System.out.println(t4.getName());

        Thread t5 = new Thread(()->{
            System.out.println("Runnable .......");
        }, "RunnableThread");
        System.out.println(t5.getName());

    }
}
