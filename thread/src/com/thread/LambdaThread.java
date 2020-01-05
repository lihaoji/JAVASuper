package com.thread;

/**
 * @author lihaoji
 * @create 2019-11-23 15:00
 */
public class LambdaThread {
    public static void main(String[] args) {

        Demo demo = new Demo();

        new Thread(new Runnable() {
        @Override
        public void run() {
            demo.get();
        }
    },"A").start();

        new Thread(()->{
            demo.get1();
        },"B").start();

    }



}

class Demo{

    public void get(){
        System.out.println("lll");
    }

    public void get1(){
        System.out.println("2222ll");
    }




}
