package com.lhalj.java.escape;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:理解泛型
 */
public class Genericity {

    /*
     * 简单使用泛型
     * 泛型擦除 伪泛型 编译期间会擦除所有编译信息
     */
    private static void easyUse() throws Exception{

        List<String> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();


        List<Integer> list = new ArrayList<>();
        list.add(1);
        //反射 拿到运行时的容器类
        list.getClass().getMethod("add",Object.class).invoke(list,"abcd");
        list.getClass().getMethod("add",Object.class).invoke(list,1.2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    /*
     * 泛型 先检查 后编译
     * 泛型编译之后没有类型的概念
     */
    private static void checkAndCompile(){

        ArrayList<String> list = new ArrayList<>();
        list.add("123");
    }

    /*
     * 泛型不支持继承
     */
    private static void genericityCanNotExtend(){

        // 第一类错误
        //ArrayList<String> first = new ArrayList<Object>();
        ////展开形式
        //ArrayList<Object> list1 = new ArrayList<Object>();
        //list1.add(new Object());
        //ArrayList<String> list2 = list1;

        //第二类错误·
        //ArrayList<Object> second = new ArrayList<String>();
        //
        //ArrayList<String> list1 = new ArrayList<>();
        //list1.add(new String());
        //ArrayList<Object> list2 = list1;
    }

    /*
     * 泛型类型变量不能是基本数据类型
     */
    private static void baseTypeCanNotUseGenericity(){

        //List<int> invalid = new ArrayList<>();
        //泛型擦除之后 ArrayList是Object类型 无法保存int

    }

    /*
     * 泛型的类型参数只能是类类型 不能是简单类型
     */
    private static <T> void doSomething(T... values){
        for(T value: values){
            System.out.println(value);
        }
    }


    public static void main(String[] args) throws Exception {
        //easyUse();
        Integer[] int1 = new Integer[]{1,2,3,4};
        //把int当成了一个类类型 打印出来
        int[] int2 = new int[]{1,2,3,4};
        doSomething(int1);
        System.out.println("-------------------------");
        System.out.println(int2);
    }
}
