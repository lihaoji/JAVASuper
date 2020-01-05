package com.lhj.sp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证Volatile可见性
 * @author lihaoji
 * @create 2019-12-21 20:57
 */
public class VolatileDemo {

    public static void main(String[] args) {

        myData myData = new myData();
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{

                for (int j = 0; j <1000 ; j++) {
                    myData.addPlus1000();
                    myData.acomic();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){//后台默认两个线程 mian  GC
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"number===="+myData.number);
        System.out.println(Thread.currentThread().getName()+"actomic===="+myData.atomicInteger);

    }




    //可见性
    private static void seeOKVolatile() {
        myData myData = new myData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addNum();
            System.out.println(Thread.currentThread().getName()+"\t update"+myData.number);
        },"AAA").start();

        //main 线程
        while (myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t 结束====" + myData.number);
    }

}

class  myData{
    volatile int number = 0;//volatile 可见性 通知main线程
    public void addNum(){
        this.number = 60;
    }

    public void addPlus1000(){
        number++;
    }


    //解决volatile 的不保证原子性问题
    AtomicInteger atomicInteger = new AtomicInteger();

    public void acomic(){
        atomicInteger.getAndIncrement();
    }

}
