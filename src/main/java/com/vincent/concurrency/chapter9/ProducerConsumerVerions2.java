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
                System.out.println("P->" + i);
                //TODO: 通知已经生产
                isProduced = true;
                LOCK.notify();
            }
        }
    }

    public void consume(){
        synchronized (LOCK){
            if(isProduced){
                System.out.println("C->" + i);
                LOCK.notify();
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
