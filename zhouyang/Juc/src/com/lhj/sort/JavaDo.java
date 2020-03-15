package com.lhj.sort;

/**
 * @author lihaoji
 * @create 2020-03-12 19:21
 */
public class JavaDo {

    private String name;

    public JavaDo(){

        System.out.println("父类午餐构造器");
    }

    public JavaDo(String name) {
        this.name = name;
        System.out.println("父类有参数构造器");
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类非静态代码块");
    }

    public void father(){
        System.out.println("父类普通方法");
    }



    public static void main(String[] args) {

        JavaDo javaDo = new JavaDo();
        JavaDo javaDo1 = new JavaDo("jjjjj");
        javaDo.father();
        System.out.println(javaDo.name);
        System.out.println("父类主程序");

    }
}

class Child extends JavaDo{

    {
        System.out.println("Child---执行非静态代码块了1！");
    }


    static{
        System.out.println("Child---执行静态代码块了1！");
    }


    public Child(){
        super();
        System.out.println("Child---无参构造函数！");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
