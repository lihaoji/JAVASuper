package com.lhj.jvmgc;

/**
 * @author lihaoji
 * @create 2020-01-05 20:57
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===================hello GC");

        Thread.sleep(Integer.MAX_VALUE);
        //jps -l
        //jinfo -flag UseSerialGC 10004
        // java -XX:+PrintFlagsInitial 默认打印Jvm所有初始化数据
        // Java -XX:+PrintFlagsFinal 查看jvm 修改或者更新过的数据
    }
}
