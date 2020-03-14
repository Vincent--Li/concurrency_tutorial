package com.vincent.concurrency.pratice;

/**
 * 不要以字符串常量作为锁定对象, 下面例子中m1和m2指向的是堆内存中同一个地址
 * 字符串常量相同的话会被复用
 *
 * @Author Vincent Li
 * @Date 2020/3/14 21:47
 */
public class SynchronizedFeature2 {
    String s1 = "Hello";
    String s2 = "Hello";

    void m1(){
        synchronized (s1){

        }
    }
    void m2(){
        synchronized (s2){

        }
    }
}
