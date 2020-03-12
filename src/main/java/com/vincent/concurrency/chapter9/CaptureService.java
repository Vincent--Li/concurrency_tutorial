package com.vincent.concurrency.chapter9;

import java.util.*;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/12 23:32
 */
public class CaptureService {

    final static private LinkedList<Control> CONTROLS = new LinkedList<>();
    final static private int MAX_WORKER = 5;

    public static void main(String[] args) {

        List<Thread> workers = new ArrayList<>();
        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10", "M11")
                .stream().map(CaptureService::createCaptureThread)
                .forEach(t -> {
                    t.start();
                    workers.add(t);
                });

        workers.stream().forEach(t ->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of capture worker finished ").ifPresent(System.out::println);

    }

    private static Thread createCaptureThread(String name){
        return new Thread(()-> {
            Optional.of("The worker [" + Thread.currentThread().getName() + "] begin capture data").ifPresent(System.out::println);
            synchronized (CONTROLS){
                 while (CONTROLS.size() > MAX_WORKER){
                     try {
                         CONTROLS.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                CONTROLS.addLast(new Control());

            }


            Optional.of("The worker [" + Thread.currentThread().getName() + "] is working ...").ifPresent(System.out::println);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (CONTROLS){
                Optional.of("The worker [" + Thread.currentThread().getName() + "] end capture data ...").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }

        }, name);

    }

    private static class Control{

    }
}
