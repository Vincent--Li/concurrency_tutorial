package com.vincent.concurrency.chapter1;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/2/29 22:16
 */
public abstract class TemplateMethod {
    public final void print(String message){
        System.out.println("###################");
        wrapPrint(message);
        System.out.println("###################");
    }

    protected void wrapPrint(String message){

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };
        t1.print("Hello");
    }
}
