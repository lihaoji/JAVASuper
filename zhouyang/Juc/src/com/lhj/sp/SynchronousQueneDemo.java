package com.lhj.sp;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * d不存储元素   单个对列
 * @author lihaoji
 * @create 2019-12-29 15:39
 */
public class SynchronousQueneDemo {

    public static void main(String[] args) {

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();//默认非公平锁

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put ok 1");
                synchronousQueue.put("ss");


                System.out.println(Thread.currentThread().getName()+"\t put ok 2");
                synchronousQueue.put("ss");


                System.out.println(Thread.currentThread().getName()+"\t put ok 3");
                synchronousQueue.put("ss");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();


        new Thread(()->{
            try {

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"\t take ok 1");
                synchronousQueue.take();


                System.out.println(Thread.currentThread().getName()+"\t take ok 2");
                synchronousQueue.take();


                System.out.println(Thread.currentThread().getName()+"\t take ok 3");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }



}
