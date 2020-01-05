package com.lhj.sp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lihaoji
 * @create 2019-12-29 14:37
 */
public class BlockQueueDemo {

    public static void main(String[] args) {

        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add("a");
        blockingQueue.add("dd");
        blockingQueue.add("ff");
       // blockingQueue.add("q");//Exception in thread "main" java.lang.IllegalStateException: Queue full


        System.out.println("队首元素是 \t"+blockingQueue.element());//队首元素是 	a

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());//Exception in thread "main" java.util.NoSuchElementException

        System.out.println("========================================以上是异常组=======================================");


        System.out.println("========================================以下是返回特殊值组=======================================");

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
       // System.out.println(blockingQueue.offer("as"));//false

        System.out.println(blockingQueue.peek()); //队首元素

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll()); //取值 队列中没有返回null

        System.out.println("========================================以下阻塞组=======================================");


        System.out.println("========================================以下阻塞组=======================================");
/*
        try {
            blockingQueue.put("s");
            blockingQueue.put("d");
            blockingQueue.put("f");
           // blockingQueue.put("s");//队列满了再添加  线程会一直阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

/*        try {
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();//队列空了 再移除 会一直阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        System.out.println("========================================以下超时退出=======================================");


        System.out.println("========================================以下超时退出=======================================");

        try {
            blockingQueue.offer("H",2L, TimeUnit.SECONDS);
            blockingQueue.offer("H",2L, TimeUnit.SECONDS);
            blockingQueue.offer("H",2L, TimeUnit.SECONDS);
            blockingQueue.offer("H",2L, TimeUnit.SECONDS);//超时自动退出
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            String poll = blockingQueue.poll(2, TimeUnit.SECONDS);
            System.out.println(poll+"\tkkk");
            blockingQueue.poll(2,TimeUnit.SECONDS);
            blockingQueue.poll(2,TimeUnit.SECONDS);
            blockingQueue.poll(2,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
