package com.vincent.concurrency.pratice;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/14 21:14
 */
public class VolatileFeature2 {
    //volatile只能保证可见性, 不能保证原子性.
    /*volatile */ int count = 0;

    synchronized void m(){
        for(int i = 0; i< 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        VolatileFeature2 t = new VolatileFeature2();

        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i< 10; i++){
            threads.add(new Thread(t::m, "Thread "+ i));
        }

        threads.forEach((o)-> o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
