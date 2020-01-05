package com.thread;

/**
 * @author lihaoji
 * @create 2019-11-23 15:33
 */
public class ShareDataOne {

    private Integer number = 0;

    public synchronized void incrNum() throws InterruptedException{
        while (number==0){
            this.wait();
        }
        --number;
        System.out.print(Thread.currentThread().getName()+"  "+number);
        this.notifyAll();
    }

    public synchronized void decrNum() throws InterruptedException{
        while (number!=0){
            this.wait();
        }
        ++number;
        System.out.print(Thread.currentThread().getName()+"  "+number);
        this.notifyAll();
    }
}

class NotifyTest{

    public static void main(String[] args) {
        ShareDataOne sb = new ShareDataOne();
        new Thread(()->{

            for (int i =1;i<=10;i++){
                try {
                    sb.incrNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"AAA").start();


        new Thread(()->{
            for (int i =1;i<=10;i++){
                try {
                    sb.decrNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"BBB").start();

        new Thread(()->{

            for (int i =1;i<=10;i++){
                try {
                    sb.incrNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"CCC").start();


        new Thread(()->{
            for (int i =1;i<=10;i++){
                try {
                    sb.decrNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"DDD").start();
    }

}
