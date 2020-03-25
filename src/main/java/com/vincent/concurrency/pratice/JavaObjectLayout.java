package com.vincent.concurrency.pratice;

import org.openjdk.jol.info.ClassLayout;

public class JavaObjectLayout {

    public static void main(String[] args) {

        JavaObjectLayout object = new JavaObjectLayout();

//        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        synchronized (object){
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }

    }
}
