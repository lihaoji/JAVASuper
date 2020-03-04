package com.lhj.sort;

/**
 * @author lihaoji 冒泡排序
 * @create 2020-03-03 14:59
 */
public class MaoPaoSort {

    public static void main(String[] args) {

        int arr[] = {2,6,17,8,9,20};

        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+i] = temp;
                }

            }
        }

        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }


}
