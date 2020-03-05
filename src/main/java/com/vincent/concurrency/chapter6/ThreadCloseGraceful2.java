package com.vincent.concurrency.chapter6;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 21:23
 */
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread{
        private volatile boolean start = true;

        @Override
        public void run() {
            while(start){
                //两种方式都可以
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
////                    e.printStackTrace();
//                    break;//return
//                }
                if(Thread.interrupted()) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();
    }
}
