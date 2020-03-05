package com.vincent.concurrency.chapter4;

import java.util.Optional;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 20:14
 */
public class ThreadSimpleAPI2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{

            for(int i = 0 ; i< 1000; i++){
                Optional.of(Thread.currentThread().getName() + "-Index" + i).ifPresent(System.out::println);
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(()->{

            for(int i = 0 ; i< 1000; i++){
                Optional.of(Thread.currentThread().getName() + "-Index" + i).ifPresent(System.out::println);
            }
        });

        t2.setPriority(Thread.MIN_PRIORITY);

        Thread t3 = new Thread(()->{

            for(int i = 0 ; i< 1000; i++){
                Optional.of(Thread.currentThread().getName() + "-Index" + i).ifPresent(System.out::println);
            }
        });

        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
