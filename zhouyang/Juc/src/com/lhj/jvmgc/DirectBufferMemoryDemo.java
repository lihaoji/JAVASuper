package com.lhj.jvmgc;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * @author lihaoji
 * @create 2020-02-01 16:39
 */
public class DirectBufferMemoryDemo {


    public static void main(String[] args) {

        System.out.println(" java 默认使用本地内存maxDirectMemory\t"+VM.maxDirectMemory()/(double)1024/1024); //约1/4

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);


        /**
         *  Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
         at java.nio.Bits.reserveMemory(Bits.java:693)
         at java.nio.DirectByteBuffer.<init>(DirectByteBuffer.java:123)
         at java.nio.ByteBuffer.allocateDirect(ByteBuffer.java:311)
         at com.lhj.jvmgc.DirectBufferMemoryDemo.main(DirectBufferMemoryDemo.java:18)
         *
         *
         */


    }
}
