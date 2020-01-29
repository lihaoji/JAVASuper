package com.lhj.jvmgc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author lihaoji
 * @create 2020-01-29 13:09
 */
public class PhomDemo {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();

        ReferenceQueue<Object> queue = new ReferenceQueue();

        WeakReference<Object> weakHashMap = new WeakReference<>(o1,queue);

        System.out.println(o1);
        System.out.println(weakHashMap.get());
        System.out.println(queue.poll());

        o1=null;
        System.gc();
        System.out.println("++++++++++++++++++++++++++++GC 后+++++++++++++++++++++++++++++");
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(weakHashMap.get());
        System.out.println(queue.poll());







    }
}
