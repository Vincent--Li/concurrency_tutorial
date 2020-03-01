package com.vincent.concurrency.chapter1;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/2/29 14:12
 */
public class TryConcurreycy {

    public static void main(String[] args) {

        Thread t = new Thread("Read-Thread"){
            @Override
            public void run() {
                println(Thread.currentThread().getName());
                readFromDataBase();
            }
        };

//        new Thread("Write-Thread"){
//            @Override
//            public void run() {
//                println(Thread.currentThread().getName());
//                writeDataToFile();
//            }
//        }.start();
//        t.run();  // main()线程调用
    }

    private static void readFromDataBase() {
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 10L);
            println("Read data done and start handle");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        println("The data handle finish and successful ");

    }

    private static void writeDataToFile(){
        try {
            println("Begin write data to file.");
            Thread.sleep(1000 * 20L);
            println("Write data done and start handle");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        println("The data handle finish and successful ");

    }

    private static void println(String message){
        System.out.println(message);
    }
}
