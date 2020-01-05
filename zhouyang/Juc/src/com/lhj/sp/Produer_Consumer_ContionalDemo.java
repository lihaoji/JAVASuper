package com.lhj.sp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lihaoji
 * @create 2019-12-29 16:15
 */
class ShareDta{

    private int number = 0;

    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while (number!=0)
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number==0)
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}



public class Produer_Consumer_ContionalDemo {

    public static void main(String[] args) {
        ShareDta shareDta = new ShareDta();
        new Thread(()->{

            for (int i = 1; i <=5 ; i++) {

                shareDta.increment();

            }

        },"SSSS").start();

        new Thread(()->{

            for (int i = 1; i <=5 ; i++) {

                shareDta.decrement();

            }

        },"DDDD").start();

        new Thread(()->{

            for (int i = 1; i <=5 ; i++) {

                shareDta.increment();

            }

        },"RRRR").start();

        new Thread(()->{

            for (int i = 1; i <=5 ; i++) {

                shareDta.decrement();

            }

        },"FFFF").start();

    }


}
