package com.vincent.concurrency.chapter6;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/5 21:28
 */
public class ThreadCloseForce {

    public static void main(String[] args) {
       ThreadService service = new ThreadService();
       long start =  System.currentTimeMillis();
       service.execute(()->{
           //模拟非常耗时的操作
//           while(true){
//
//           }
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });
       service.shutdown(10000);

       long end = System.currentTimeMillis();

       System.out.println(end - start);
    }
}
