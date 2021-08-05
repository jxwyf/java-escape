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
        Object newPerson = ois.readObject();

        //关闭输入流
        ois.close();

        System.out.println(newPerson);
    }

    public static void main(String[] args) throws Exception {
        //testSerializablePeople();
        testSerizableWorker();
    }
}
