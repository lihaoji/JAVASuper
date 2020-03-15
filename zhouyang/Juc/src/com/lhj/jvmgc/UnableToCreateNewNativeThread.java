package com.lhj.jvmgc;

/**
 * @author lihaoji
 * @create 2020-03-14 15:05
 */
public class UnableToCreateNewNativeThread {

    public static void main(String[] args) {

        for (int i = 0;  ; i++) {


            System.out.println("*********************i"+i);
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            },""+i).start();

            
        }

    }



}
