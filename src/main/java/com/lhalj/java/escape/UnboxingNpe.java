package com.lhalj.java.escape;

/**
 * @author : 刘唯卿
 * @date : 11:33 2021/2/1
 * 自动拆箱引发的空指针问题
 *
 *
 * 规避自动拆箱引发空指针的建议
 *
 * 1.基本数据类型优于包装器类型 优先考虑基本类型
 * 2.对于不确定的包装器类型 一定要校验是否为null
 * 3.对于值为null的包装器类型 赋值为0
 */
@SuppressWarnings("all")
public class UnboxingNpe {


    private static int add(int x,int y){
        return x+y;
    }

    private static boolean compare(long x,long y){
        return x>y;
    }

    public static void main(String[] args) {

        //1.变量赋值自动拆箱出现的空指针
        //javac UnboxingNpe.java
        //java -c UnboxingNpe.class
//        Long count = null;
//        long count_ = count;

        //2.方法传参时自动拆箱引发的空指针
//        Integer left = null;
//        Integer right = null;
//        System.out.println(add(left,right));

        //3. 用于大小比较d的场景
//        Long left = 10L;
//        Long right = null;
//        System.out.println(compare(left,right));
    }
}
