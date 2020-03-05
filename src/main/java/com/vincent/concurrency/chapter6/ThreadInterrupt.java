package com.vincent.concurrency.chapter6;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 20:56
 */
public class ThreadInterrupt {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {

//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                while(true){
//                    synchronized (MONITOR){
//                        try {
//                            MONITOR.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            System.out.println(isInterrupted());
//                        }
//                    }
//                }
//            }
//        };
//        t1.start();
//
//        Thread.sleep(100);
//
//        System.out.println(t1.isInterrupted());
//        t1.interrupt();
//        System.out.println(t1.isInterrupted());

        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){

                }
            }
        };

        t.start();

        Thread main = Thread.currentThread();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                main.interrupt();
                System.out.println("interrupting t");
            }
        };

        t2.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
