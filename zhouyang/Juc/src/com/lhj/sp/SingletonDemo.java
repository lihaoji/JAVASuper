package com.lhj.sp;

/**
 * @author lihaoji
 * @create 2019-12-08 21:03
 */
public class SingletonDemo {

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t我是单例构造方法");
    }

    private static volatile SingletonDemo singletonDemo;

    public static SingletonDemo getSingletonDemo(){
        if (null==singletonDemo){
            synchronized (SingletonDemo.class){
                if (null==singletonDemo){
                    singletonDemo = new SingletonDemo();
                }
            }
        }

        return singletonDemo;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getSingletonDemo()==SingletonDemo.getSingletonDemo());
//        System.out.println(SingletonDemo.getSingletonDemo()==SingletonDemo.getSingletonDemo());
//        System.out.println(SingletonDemo.getSingletonDemo()==SingletonDemo.getSingletonDemo());
//        System.out.println(SingletonDemo.getSingletonDemo()==SingletonDemo.getSingletonDemo());
//
//        System.out.println("============================");

        for (int i = 1; i <=10 ; i++) {
            new Thread(()->{
                SingletonDemo.getSingletonDemo();
            },String.valueOf(i)).start();


        }
    }
}



