package com.vincent.concurrency.chapter4;

import java.util.Optional;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 8:58
 */
public class ThreadSimpleAPI {

    public static void main(String[] args) {

        Thread t = new Thread(()->{
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");


        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
    }
}
