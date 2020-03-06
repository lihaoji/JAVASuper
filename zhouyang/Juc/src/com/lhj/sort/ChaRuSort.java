package com.lhj.sort;

/**
 * @author lihaoji  插入排序
 * @create 2020-03-06 17:58
 */
public class ChaRuSort {

    public static void main(String[] args) {
        int arr[] = {7,2,3,5,6,78};

        //外层循环
        for (int i = 1; i < arr.length; i++) {


            //内层循环比较
            for (int j = i; j >0 ; j--) {


                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else {
                    break;
                }


            }
        }

        for (int i : arr) {
            System.out.println(i);
        }


    }
}
