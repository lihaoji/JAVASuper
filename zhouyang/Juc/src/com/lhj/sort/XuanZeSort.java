package com.lhj.sort;

/**
 * @author lihaoji 选择排序
 * @create 2020-03-03 16:10
 */
public class XuanZeSort {

    public static void main(String[] args) {

        int arr[] = {2,6,17,8,9,20};


        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];//默认选择第一个为最小值

            int index = i;//记录最小数字小角标

            //遍历之后的数字找出最小值
            for (int j = i+1; j < arr.length; j++) {
                if (min>arr[j]){
                    min = arr[j];//替换最小值
                    index = j;//替换下角标
                }
            }

            //交换位置
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;


        }

        for (int i : arr) {
            System.out.println(i);
        }




    }
}
