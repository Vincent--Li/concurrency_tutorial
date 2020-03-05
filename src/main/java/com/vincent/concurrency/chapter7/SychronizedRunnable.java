package com.vincent.concurrency.chapter7;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:27
 */
public class SychronizedRunnable implements Runnable {

    private int index = 1;

    private final static int  MAX = 1000;

    private final Object MONITOR = new Object();

    //相当于锁的是this
    @Override
    public void run() {

        while(true){

            if(ticket()){
                break;
            }


        }
    }

    private synchronized boolean ticket(){
        if(index > MAX){
            return true;
        }

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
        return false;
    }
}
