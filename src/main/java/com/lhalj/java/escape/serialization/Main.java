package com.lhalj.java.escape.serialization;

import java.io.*;

/**
 * 描述:序列化和反序列化
 */
@SuppressWarnings("all")
public class Main {

    /*
     * 序列化和反序列化 People对象
     */
    private static void testSerializablePeople() throws Exception{

        //序列化的步骤

        //用于存储序列化的文件
        File file = new File("/tmp/people_10.java_");
        People p = new People(10l);

        //创建一个输出流
        OutputStream out;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //输出可序列化对象
        oos.writeObject(p);

        //关闭输出流
        oos.close();


        //反序列化的步骤

        //创建一个输入流
        InputStream in;
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );

        //得到序列化的对象
        Object newPerson = ois.readObject();

        //关闭输入流
        ois.close();

        System.out.println(newPerson);
    }

    /*
     * 子类实现序列化 父类不实现序列化
     * 只要父类实现了无参的构造函数 子类是可以序列化的
     */
    private static void testSerizableWorker() throws  Exception{
        //序列化的步骤

        //用于存储序列化的文件
        File file = new File("/tmp/people_10.java_");
        Worker p = new Worker(10l,"1",12);

        //创建一个输出流
        OutputStream out;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //输出可序列化对象
        oos.writeObject(p);

        //关闭输出流
        oos.close();


        //反序列化的步骤

        //创建一个输入流
        InputStream in;
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );

        //得到序列化的对象
        Object newWorker = ois.readObject();

        //关闭输入流
        ois.close();

        System.out.println(newWorker);
    }


    /*
     * 类中存在引用对象 所有对象都需要实现序列化
     */
    private static void testSerializableCombo() throws Exception{
        //序列化的步骤

        //用于存储序列化的文件
        File file = new File("/tmp/people_10.java_");
        Combo p = new Combo(10,new People());

        //创建一个输出流
        OutputStream out;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //输出可序列化对象
        oos.writeObject(p);

        //关闭输出流
        oos.close();


        //反序列化的步骤

        //创建一个输入流
        InputStream in;
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );

        //得到序列化的对象
        Object combo = ois.readObject();

        //关闭输入流
        ois.close();

        System.out.println(combo);
    }

    /*
     * 同一个对象多次序列化的问题 坑
     * 序列化编码号
     * 有属性更新 会影响到序列化
     */
    private static void sameObjectRepeatedSerialization() throws Exception{
        //序列化的步骤

        //用于存储序列化的文件
        File file = new File("/tmp/people_more.java_");
        People p = new People(10l);
        //创建一个输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        //输出可序列化对象
        oos.writeObject(p);
        //第二次序列化
        oos.writeObject(p);
        //修改值
        p.setId(20l);
        //第三次系列化
        oos.writeObject(p);

        //关闭输出流
        oos.close();


        //反序列化的步骤

        //创建一个输入流
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );

        //得到序列化的对象
        Object people1 = ois.readObject();
        Object people2 = ois.readObject();
        Object people3 = ois.readObject();

        //关闭输入流
        ois.close();

        System.out.println(people1);
        System.out.println(people2);
        System.out.println(people3);
    }

    public static void main(String[] args) throws Exception {
        //testSerializablePeople();
        // testSerizableWorker();
        //testSerializableCombo();
        sameObjectRepeatedSerialization();
    }
}
