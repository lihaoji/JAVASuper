package com.lhj.sp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读锁 共享锁
 * 写锁 独占锁
 * @author lihaoji
 * @create 2019-12-27 21:42
 */
public class ReadWriteLockDemo {

    private volatile Map<String,Object> map = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void putWrite(String key , Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在写入: "+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写入完成: ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void getRead(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在读取:");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取完成: ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }


    public static void main(String[] args) {

        ReadWriteLockDemo lockDemo = new ReadWriteLockDemo();

        for (int i = 0; i < 5 ; i++) {
            final int temp = i;
            new Thread(()->{
                lockDemo.putWrite(temp+"",temp);
            },String.valueOf(i)).start();

        }


        for (int i = 0; i < 5 ; i++) {
            final int temp = i;
            new Thread(()->{
                lockDemo.getRead(temp+"");
            },String.valueOf(i)).start();

        }


    }

}
