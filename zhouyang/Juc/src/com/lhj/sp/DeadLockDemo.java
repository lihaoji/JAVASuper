package com.lhj.sp;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 * @author lihaoji
 * @create 2020-01-05 16:59
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new LockDead(lockA,lockB),"AAA").start();
        new Thread(new LockDead(lockB,lockA),"BBB").start();
    }



}


class LockDead implements Runnable{

    private String lockA;
    private String lockB;

    public LockDead(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t持有锁:"+lockA+"\t想获得锁:"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t持有锁:"+lockB+"\t想获得锁:"+lockA);
            }
        }




    }
}
