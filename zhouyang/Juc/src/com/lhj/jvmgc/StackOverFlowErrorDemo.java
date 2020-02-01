package com.lhj.jvmgc;

/**
 * @author lihaoji
 * @create 2020-02-01 15:17
 */
public class StackOverFlowErrorDemo {

    public static void main(String[] args) { // "main" java.lang.StackOverflowError

        stackOverFlowErrorMethod();
    }

    private static void stackOverFlowErrorMethod() {

        stackOverFlowErrorMethod();
    }
}
