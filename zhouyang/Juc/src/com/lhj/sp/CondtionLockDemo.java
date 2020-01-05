package com.lhj.sp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 精准唤醒
 * @author lihaoji
 * @create 2019-12-29 19:58
 */
public class CondtionLockDemo {

    private Integer num = 1;

    private Lock lock = new ReentrantLock();

    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();

        try {
            while (num!=1){
                c1.await();
            }

            for (int i = 1; i <=5 ; i++) {

                System.out.println(Thread.currentThread().getName()+"\t"+i);

            }
            System.out.println();
            num=2;
            c2.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

    }

    public void print10() throws InterruptedException {
        lock.lock();

        try {
            while (num!=2){
                c2.await();
            }

            for (int i = 1; i <=10 ; i++) {

                System.out.println(Thread.currentThread().getName()+"\t"+i);

            }
            System.out.println();
            num=3;
            c3.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

    }

    public void print15() throws InterruptedException {
        lock.lock();

        try {
            while (num!=3){
                c3.await();

            }

            for (int i = 1; i <=15 ; i++) {

                System.out.println(Thread.currentThread().getName()+"\t"+i);

            }
            System.out.println();
            num=1;
            c1.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

    }



}


class SignalDemo{
    public static void main(String[] args) {

        CondtionLockDemo condtionLockDemo = new CondtionLockDemo();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    condtionLockDemo.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    condtionLockDemo.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    condtionLockDemo.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CCC").start();

    }
}
