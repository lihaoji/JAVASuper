package com.lhj.sp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *
 * atomicstampedReference
 * @author lihaoji
 * @create 2019-12-21 22:44
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
/*
      new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"SSSS").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+atomicReference.compareAndSet(100,2222)+"\t"+atomicReference.get());
        },"TTTT").start();
*/


        System.out.println("==============以下解决ABA问题========");

        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t version_1"+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);//等待T4 拿到相同版本号
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t version_2"+stampedReference.getStamp());

            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t version_3"+stampedReference.getStamp());

        },"T3").start();

        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t vsersion_1"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);//等待T3完成比较并交换
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = stampedReference.compareAndSet(100, 2020, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"\t 结果"+result+"\t vsersion_2=="+stampedReference.getStamp()+"\t 真实=="+stampedReference.getReference());
        },"T4").start();



    }
}
