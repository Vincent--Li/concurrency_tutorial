package com.vincent.concurrency.chapter9;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/11 22:21
 */
public class ProducerConsumerVerions2 {

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
        ProducerConsumerVerions2 pc = new ProducerConsumerVerions2();

        new Thread("P"){
            @Override
            public void run() {
                while(true){
                    pc.produce();
                }
            }
        }.start();

        new Thread("C"){
            @Override
            public void run() {
                while(true){
                    pc.consume();
                }
            }
        }.start();
    }
}
