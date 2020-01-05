package com.lhj.sp;

import java.util.concurrent.*;

/**
 * @author lihaoji
 * @create 2020-01-03 21:17
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
      //  ExecutorsDemo();

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                        5,10,3L,
                        TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());


        try {
            for (int i = 1; i <=50 ; i++) {
                final int temp = i;
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t处理"+temp+"号业务");
                });
                //TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    private static void ExecutorsDemo() {
        /* System.out.println(Runtime.getRuntime().availableProcessors());//底层CPU 核数*/

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService stealingPool = Executors.newWorkStealingPool();

        ThreadFactory threadFactory1 = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };

        //固定线程
/*
        try {
            for (int i = 1; i <=10 ; i++) {
                final int temp = i;
                fixedThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t处理"+temp+"号业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fixedThreadPool.shutdown();
        }
*/


 /*       try {
            for (int i = 1; i <=10 ; i++) {
                final int temp = i;
                singleThreadExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t处理"+temp+"号业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fixedThreadPool.shutdown();
        }
*/

        try {
            for (int i = 1; i <=100 ; i++) {
                final int temp = i;
                newCachedThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t处理"+temp+"号业务");
                });
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fixedThreadPool.shutdown();
        }
    }
}
