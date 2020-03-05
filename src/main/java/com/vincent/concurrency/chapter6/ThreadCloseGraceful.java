package com.vincent.concurrency.chapter6;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 21:17
 */
public class ThreadCloseGraceful {

    //通过开关的方式, 关闭线程, volatile在这里不会有太大影响.
    // 因为, 只是暂时的缓存没有看到. 当其他线程收到消息后, 最终还是会停止下来的


    private static class Worker extends Thread{
        private volatile boolean start = true;

        @Override
        public void run() {
            while(start){

            }
        }

        public void shutdown(){
            this.start = false;
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

        worker.shutdown();
    }
}
