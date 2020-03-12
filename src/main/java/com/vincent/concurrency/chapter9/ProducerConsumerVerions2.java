package com.vincent.concurrency.chapter9;

import java.util.stream.Stream;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/11 22:21
 */
public class ProducerConsumerVerions2 {
    //WARNING 如果多个consume和produce情况会出现问题
    // 原因, 如果只用notify, 只会传播给wait队列中的一个. 如果notify/wait都是P, 或者都是C, 那么另外一组就会陷入等待.

    private int i = 0;

    final  private Object LOCK = new Object();

    private volatile  boolean isProduced = false;

    public void produce(){
        synchronized (LOCK){
            if(isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                i++;
                System.out.println(Thread.currentThread().getName()+"->" + i);
                //TODO: 通知已经生产
                isProduced = true;
                LOCK.notifyAll();
            }
        }
    }

    public void consume(){
        synchronized (LOCK){
            if(isProduced){
                System.out.println(Thread.currentThread().getName()+"->" + i);
                LOCK.notifyAll();
                isProduced = false;
            }else{
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        //这种情况没有形成死锁, 只是每个线程都在wait,
        // wait 意味着放弃了CPU执行权

        // 1P NC 情况C1可能通知到C2, 这样的话P仍然在wait
        // NP 1C 情况同上, P1可能通知到P2, 这样C仍然在wait
        // NP NC 情况同上.
        // notifyAll的问题, 如果Pm正在生产, Pn抢占到锁并且在wait,
        //  那么会出现Pm生产1次, Pn生产1次. Pm的生产未被消费
        ProducerConsumerVerions2 pc = new ProducerConsumerVerions2();
        Stream.of("P1", "P2").forEach(n ->
                new Thread(n){
                    @Override
                    public void run() {
                        while(true){
                            pc.produce();
                        }
                    }
                }.start()
        );

        Stream.of("C1", "C2").forEach(n ->
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
