package com.lhj.sp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lihaoji
 * @create 2019-12-23 21:46
 */
public class ContainerNoSaleDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = Collections.synchronizedList(list);//1.集合辅助工具类 线程安全
        List<String> listCopy = new CopyOnWriteArrayList<>();//juc 并发集合
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                listCopy.add(UUID.randomUUID().toString().substring(0,6));//java.util.ConcurrentModificationException并发异常
                System.out.println(listCopy);
            },String.valueOf(i)).start();
        }

    }
}
