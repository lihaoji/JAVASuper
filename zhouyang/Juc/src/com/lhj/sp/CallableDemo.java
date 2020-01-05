package com.lhj.sp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lihaoji
 * @create 2020-01-03 20:19
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new ThreadCall());
        FutureTask<Integer> futureTask1 = new FutureTask<>(new ThreadCall());
        Thread t1  = new Thread(futureTask, "AAA");
        Thread t2 = new Thread(futureTask1, "BBB");
        t1.start();
        t2.start();

        try {
            while (!futureTask.isDone()){//直到计算完毕才get

            }
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}


class ThreadCall implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t come!!!");
        return 1024;
    }
}
