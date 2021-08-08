package com.lhalj.java.escape.clone;

/**
 * 描述: 理解深拷贝和浅拷贝
 */
public class Main {

    private static void canNotClone() throws CloneNotSupportedException {
        Main main = new Main();
        Object cloned = main.clone();
    }


    private static void copyTest() throws CloneNotSupportedException {
        Worker worker1 = new Worker("java",25,"m","大学","2000");
        System.out.println("原始对象: " + worker1.getEducationInfo().getSchool());

        Worker worker2 = (Worker) worker1.clone();
        System.out.println("拷贝对象: " + worker2.getEducationInfo().getSchool());

        worker2.getEducationInfo().setSchool("同济大学");
        System.out.println("原始对象: " + worker1.getEducationInfo().getSchool());
        System.out.println("拷贝对象: " + worker2.getEducationInfo().getSchool());
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        //canNotClone();
        copyTest();
    }
}
