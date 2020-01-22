package com.lhj.jvmgc;

/**
 * @author lihaoji
 * @create 2020-01-05 20:57
 */
public class HelloGCDemo {
    public static void main(String[] args) throws InterruptedException {


        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("totalMemory:\t"+totalMemory+"字节"+"\t=="+(totalMemory/(double)1024/1024)+"\tMB"); //初始大小堆内存 -Xms
        System.out.println("maxMemeory:\t"+maxMemory+"字节"+"\t=="+(maxMemory/(double)1024/1024)+"\tMB");// 初始化最大堆内存 -Xmx


    }
}
