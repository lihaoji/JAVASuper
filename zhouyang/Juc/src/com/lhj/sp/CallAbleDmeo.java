package com.lhj.sp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lihaoji
 * @create 2019-12-28 21:26
 */
public class CallAbleDmeo implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {

        int sum = 0;

        for (int i = 0; i <= 100000; i++) {
            sum += i;
        }

        return sum;
    }
}


class ThreadCallDemo{

    public static void main(String[] args) {
        CallAbleDmeo callAbleDmeo = new CallAbleDmeo();
        FutureTask<Integer> futureTask = new FutureTask<>(callAbleDmeo);

        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();

        try {
            Integer integer = futureTask.get();
            System.out.println(integer);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}