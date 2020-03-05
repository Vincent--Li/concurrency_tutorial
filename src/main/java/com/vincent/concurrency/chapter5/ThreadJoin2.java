package com.vincent.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 20:32
 */
public class ThreadJoin2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                System.out.println();
                Thread.sleep(10_000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        t1.start();
        t1.join(100,10);

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));

        //有一些Jetty等服务, 采用守护线程的实现方式. 在主线程结束的时候. 就会自动退出.
        //这样有的时候我们就能看到, 当前的服务一挂, 整个服务就down了
        // Thread.currentThread().join() 这种写法意味着, 当前线程在等待自己结束, 但是自己并没有结束

    }
}
