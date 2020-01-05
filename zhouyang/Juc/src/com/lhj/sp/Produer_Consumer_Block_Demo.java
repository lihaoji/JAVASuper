package com.lhj.sp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lihaoji
 * @create 2019-12-29 21:31
 */
public class Produer_Consumer_Block_Demo {

    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingDeque = null;

    public Produer_Consumer_Block_Demo(BlockingQueue<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
        System.out.println("blockingQuene====="+blockingDeque.getClass().getName());
    }

    public void myProducer() throws InterruptedException {
        String data = null;
        boolean reValue;
        while (FLAG){
           data =  atomicInteger.incrementAndGet()+"";
            reValue = blockingDeque.offer(data,2L, TimeUnit.SECONDS);
            if (reValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入对列+"+data+"+成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入对列失败！！！");
            }

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName()+"\t 生产结束 FLAG===FALSE！！！");

    }

    public void myConsumer() throws InterruptedException {
        String data = null;

        while (FLAG){
            data = blockingDeque.poll(2L, TimeUnit.SECONDS);

            if (data!=null && !data.equalsIgnoreCase("")){
                System.out.println(Thread.currentThread().getName()+"\t 移除对列"+data+"成功");
            }else{
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 移除对列失败");
                System.out.println("结束====消费退出！！！！！！");

                return;
            }
        }

    }


    public void stopFac(){
        this.FLAG = false;
    }


}

class Demo{

    public static void main(String[] args) {

        Produer_Consumer_Block_Demo pcbo = new Produer_Consumer_Block_Demo(new ArrayBlockingQueue<>(11));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动！");
            try {
                pcbo.myProducer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"myPro").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线启动！！！！");
            try {
                pcbo.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"myConsumer").start();


        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Thread.currentThread().getName()+"\t 6s************一切停止");
        pcbo.stopFac();
    }
}
