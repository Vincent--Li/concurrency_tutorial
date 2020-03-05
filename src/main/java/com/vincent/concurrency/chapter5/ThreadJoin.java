package com.vincent.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 20:26
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            IntStream.range(1, 1000)
                    .forEach(
                            i->System.out.println(Thread.currentThread().getName() + "->" + i
                            ));
        });

        Thread t2 = new Thread(()->{
            IntStream.range(1, 1000)
                    .forEach(
                            i->System.out.println(Thread.currentThread().getName() + "->" + i
                            ));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //以上的两个线程执行完成后才会执行主线程
        Optional.of("All of test finish done.").ifPresent(System.out::println);

        IntStream.range(1, 1000)
                .forEach(
                        i->System.out.println(Thread.currentThread().getName() + "=>" + i
                        ));
    }
}
