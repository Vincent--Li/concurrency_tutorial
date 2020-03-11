package com.vincent.concurrency.chapter9;

import java.util.stream.Stream;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/11 22:53
 */
public class ProducerConsumerVersion3 {

    private int i = 0;

    final  private Object LOCK = new Object();

    private volatile  boolean isProduced = false;

    public void produce(){
        synchronized (LOCK){

            while(isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            i++;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            //TODO: 通知已经生产
            isProduced = true;
            LOCK.notifyAll();

        }
    }

    public void consume(){
        synchronized (LOCK){
            while(!isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "->" + i);
            LOCK.notifyAll();
            isProduced = false;
        }
    }

    public static void main(String[] args) {

        ProducerConsumerVersion3 pc = new ProducerConsumerVersion3();
        Stream.of("P1", "P2", "P3", "P4").forEach(n ->
                new Thread(n){
                    @Override
                    public void run() {
                        while(true){
                            pc.produce();
                        }
                    }
                }.start()
        );

        Stream.of("C1", "C2", "C3").forEach(n ->
                new Thread(n){
                    @Override
                    public void run() {
                        while(true){
                            pc.consume();
                        }
                    }
                }.start());



    }
}
