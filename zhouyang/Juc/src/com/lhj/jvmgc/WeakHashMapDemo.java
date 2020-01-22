package com.lhj.jvmgc;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author lihaoji
 * @create 2020-01-22 17:26
 */
public class WeakHashMapDemo {


    /**
     * Connected to the target VM, address: '127.0.0.1:52568', transport: 'socket'
     {1=hashMap}
     =============================================================
     {1=hashMap}
     ***********************************************************
     GC bedore weakHashMap:{1=hashMap}
     =============================================================
     Disconnected from the target VM, address: '127.0.0.1:52568', transport: 'socket'
     GC after weakHashMap:{}

     * @param args
     */

    public static void main(String[] args) {
        myhashMap();
        System.out.println("***********************************************************");

        myWeakhashMap();

    }

    private static void myWeakhashMap() {


        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "hashMap";
        weakHashMap.put(key,value);
        System.out.println("GC bedore weakHashMap:"+weakHashMap);

        System.out.println("=============================================================");
        key=null;
        System.gc();
        System.out.println("GC after weakHashMap:"+weakHashMap);


    }

    private static void myhashMap() {

        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashMap";
        map.put(key,value);
        System.out.println(map);

        System.out.println("=============================================================");
        key=null;
        System.gc();
        System.out.println(map);


    }
}
