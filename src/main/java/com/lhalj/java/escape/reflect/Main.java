package com.lhalj.java.escape.reflect;

import java.lang.reflect.Method;

/**
 * 描述:java 中的反射机制
 */
public class Main {

    /*
     * 方法的参数是基本类型 反射获取Method参数类型必须一致
     */
    private static void reflectDeclaredMethod() throws Exception{
        //1.获取Boss的class对象
        Class<Boss> clz = Boss.class;
        //获取clz对象的所有方法
        Method[] methods = clz.getDeclaredMethods();
        //获取某一个方法
        Method method = clz.getDeclaredMethod("numeric", int.class);

        //Method method = clz.getDeclaredMethod("numeric", Integer.class);

        System.out.println(method.invoke(clz.newInstance(),19));

    }

    /*
     * 调用的方法属于对象的父类 getDeclaredMethod会抛出异常
     */
    private static void reflectAcquireClassMethod() throws Exception{

        Class<Boss> clz = Boss.class;
        //获取某一个方法
        //Method method = clz.getDeclaredMethod("boss", String.class);
        //Method method = clz.getDeclaredMethod("worker", String.class);

        Method superMethod = getMethod(clz,
                "worker",new Class[]{String.class});

        if(superMethod !=null){
            System.out.println(superMethod.invoke(clz.newInstance(),"boss"));
        }


    }

    private static Method getMethod(Class<?> target,
                                    String methodName,
                                    Class<?>[] argTypes){

        Method method = null;

        try {
            method = target.getDeclaredMethod(methodName,argTypes);
            //设置访问属性 设置可访问的
            method.setAccessible(true);
        }catch (NoSuchMethodException ex){
            System.out.println("can not get method: " +
                    methodName + " from " +target.getName());
        }

        if(method == null && target != Object.class){
            //递归调用
            return getMethod(target.getSuperclass(),methodName,argTypes);
        }

        return method;
    }

    public static void main(String[] args) throws Exception{
        //reflectDeclaredMethod();
        reflectAcquireClassMethod();
    }

}
