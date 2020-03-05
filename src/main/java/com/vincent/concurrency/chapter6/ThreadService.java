package com.vincent.concurrency.chapter6;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 21:30
 */
public class ThreadService {
    //通过把task定义成daemon线程实现

    private Thread executeThread;

    private boolean finished = false;

    public void execute(Runnable task){
        executeThread = new Thread(){
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);

                runner.start();

                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        };

        executeThread.start();
    }

    public void shutdown(long mills){
        long currentTime = System.currentTimeMillis();
        while(!finished){
            if((System.currentTimeMillis() - currentTime) >= mills){
                System.out.println("任务超时, 需要结束");
                executeThread.interrupt();
                break;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }

    }
}
