package com.lhalj.java.escape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 刘唯卿
 * @date : 15:27 2021/2/1
 * 字符串 数组 集合 在使用时出现空指针
 */
public class BasicUsageNpe {



    private static boolean stringEquals(String x,String y){
        return x.equals(y);
    }

    private static class User{
        private String name;
    }

    public static void main(String[] args) {
        //1. 字符串使用equals可能会报空指针错误
//        System.out.println(stringEquals("xyz",null));
//        System.out.println(stringEquals(null,"xyz"));

        //2.对象数组new 出来 但是元素没有初始化
//        User[] users = new User[10];
//        for (int i=0;i!=10;++i){
//            users[i] = new User();
//            users[i].name = "lwq"+i;
//        }

        //3.List对象addAll传递null会抛出空指针
        List<User> users = new ArrayList<User>();
        User user = null;
        List<User> users_ =null;

        users.add(user);
        users.addAll(users_);

    }


}
