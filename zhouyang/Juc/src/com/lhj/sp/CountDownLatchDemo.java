package com.lhj.sp;

import java.util.concurrent.CountDownLatch;

/**
 * 减少计数demo
 * @author lihaoji
 * @create 2019-12-28 20:54
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        //closeDoor(countDownLatch);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"\t *******被灭");
                countDownLatch.countDown();//减少
            },CountryEnum.getContry(i).getMessage()).start();


        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长统一六国！");



    }






    //减少计数
    private static void closeDoor(CountDownLatch countDownLatch) throws InterruptedException {
        for (int i = 0; i < 7 ; i++) {
            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"\t *******同学走啦");
                countDownLatch.countDown();//减少
            },String.valueOf(i)).start();


        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长锁门！");
    }
}
