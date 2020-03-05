package com.vincent.concurrency.chapter5;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 20:40
 */
public class ThreadJoin3 {

    public static void main(String[] args) throws InterruptedException {

        long startTimespent = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 30000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 15000L));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long endTimespent = System.currentTimeMillis();

        System.out.printf("Save data begin timestamp is : %s, end timestamp is : %s", startTimespent, endTimespent);

    }
}

class CaptureRunnable implements Runnable{

    private final long spendTime;
    private String machineName;

    public CaptureRunnable(String machineName, long spendTime){
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        //do the really capture data;
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName + "completed data capture and successful");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String result(){
        return machineName + " finish.";
    }
}
