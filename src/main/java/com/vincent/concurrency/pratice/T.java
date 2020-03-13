package com.vincent.concurrency.pratice;

import java.util.stream.Stream;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/13 11:20
 */
public class T {

    private int count = 0;

    public synchronized void incCount(){
        System.out.println(Thread.currentThread().getName() + " producing "+count++);
    }

    public static void main(String[] args) {

        T t = new T();

        Stream.of("T1", "T2", "T3").forEach(n ->
                new Thread(()->{
                    while(true){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        t.incCount();
                    }
                }, n).start());
    }
}
