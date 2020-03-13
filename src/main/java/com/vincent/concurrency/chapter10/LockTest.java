package com.vincent.concurrency.chapter10;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/13 0:00
 */
public class LockTest {
    public static void main(String[] args) {
        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1","T2","T3","T4").forEach(t -> {
            new Thread(()->{
                try {
                    booleanLock.lock();
                    Optional.of(Thread.currentThread().getName() + "have the lock monitor")
                            .ifPresent(System.out::println);
                    work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    booleanLock.unlock();
                }
            }, t).start();
        });
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName()+ "is working")
                .ifPresent(System.out::println);
        Thread.sleep(10_000);
    }
}
