package com.thread;

/**
 * @author lihaoji
 * @create 2019-11-22 14:10
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Jicheng jicheng = new Jicheng();
        jicheng.run();
        Jicheng jicheng1 = new Jicheng();
        System.out.println();
        jicheng1.run();
    }


}

class Jicheng extends Thread {


    @Override
    public void run() {
        boolean flag = false;
        for(int i  = 3 ; i < 100 ; i ++) {
            flag = false;
            for(int j = 2; j <= Math.sqrt(i) ; j++) {
                if(i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                System.out.print(i+"  ");
            }
        }
    }



}