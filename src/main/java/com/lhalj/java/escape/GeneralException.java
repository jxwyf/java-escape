package com.lhalj.java.escape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author : 刘唯卿
 * @date : 21:22 2021/2/1
 * 编码中的常见异常
 */
public class GeneralException {

    public static class User{
        private String name;

        public User(){}

        private User(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public static class Manager extends User{}

    public static class Worker extends User{}


    private static StaffType enumFind(String type){
        return StaffType.valueOf(type);
        //最普通 最近的的实现 try catch
    }


    /**
     * TODO:并发修改异常 没有触发
     */
    private static void concurrentModificationException(ArrayList<User> users){

        //直接使用 for 循环会触发并发修改异常
        for (User user : users) {
            if(user.getName().equals("imooc")){
                users.remove(user);
            }
        }

        //使用迭代器则没有问题
        Iterator<User> iter = users.iterator();
        while(iter.hasNext()){
            User user = iter.next();
            if(user.getName().equals("imooc")){
                users.remove(user);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>(Arrays.asList(new User("qingyi"),new User("imooc"),new User("lwq")));

        concurrentModificationException(users);


        //2.类型转换异常
//        User user1 = new Manager();
//        User user2 = new Worker();
//
//        Manager m1 = (Manager) user1;
//        Manager m2 = (Manager) user2;

        //3.枚举查找异常
        System.out.println(enumFind("RD"));
        System.out.println(enumFind("AD"));

    }

}
