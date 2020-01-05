package com.lhj.sp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lihaoji
 * @create 2019-12-21 20:54
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        boolean compareAndSet = atomicInteger.compareAndSet(5, 333);//期望值 更新值
        System.out.println(compareAndSet+"\t data == "+atomicInteger.get());//qqq

        boolean compareAndSet11 = atomicInteger.compareAndSet(5, 1024);//期望值 更新值
        System.out.println(compareAndSet11+"\t data == "+atomicInteger.get());


        //ABA 问题
        boolean ABA = atomicInteger.compareAndSet(333, 333);//期望值 更新值
        System.out.println(ABA+"\t data == "+atomicInteger.get());//qqq

        boolean ABA1 = atomicInteger.compareAndSet(333, 666);//期望值 更新值
        System.out.println(ABA1+"\t data == "+atomicInteger.get());//qqq


    }


}
