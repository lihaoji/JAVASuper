package com.lhj.sp;

import java.util.concurrent.atomic.AtomicReference;

/**
 *原子引用
 *
 * @author lihaoji
 * @create 2019-12-21 22:24
 */

class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class AtomicRefenceDemo {

    public static void main(String[] args) {

        User a3 = new User("aaa", 22);
        User li4 = new User("li4", 25);
        AtomicReference<User> userAtomicReference = new AtomicReference<User>();
        userAtomicReference.set(a3);

        System.out.println(userAtomicReference.compareAndSet(a3,li4)+"\t"+userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(a3,li4)+"\t"+userAtomicReference.get().toString());



    }


}
