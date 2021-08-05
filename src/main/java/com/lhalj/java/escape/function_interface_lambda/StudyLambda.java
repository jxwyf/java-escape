package com.lhalj.java.escape.function_interface_lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述:Lambda表达式的使用
 */
public class StudyLambda {


    /*
     * java 1.8之前创造线程
     */
    private static void baseUse(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class Thread run()");
            }
        }).start();
    }

    /*
     * java 1.8创造线程
     */
    private static void easyUseLambda(){
        new Thread(()->{
            System.out.println("Anonymous Class Thread run()");
        }).start();
    }

    /*
     * 按照字符串长度进行排序
     */
    private static void myCompre(){

        //java8之前
        List<String> list = Arrays.asList("z","y","x","a");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                if(s1==null)
                    return -1;
                if(s2==null)
                    return 1;

                return s1.length() - s2.length();
            }
        });

        //java8使用Lambda表达式实现
        Collections.sort(list,(s1,s2)->{
            if(s1==null)
                return -1;
            if(s2==null)
                return 1;
            return s1.length() - s2.length();
        });
    }

    /*
     * 理解stream的中间操作和结束操作
     */
    private static void howToUseLambda(){

        List<String> names = Arrays.asList("qiyi","21");

        List<String> newNams = names.stream().filter(n ->n.startsWith("q"))
                .map(n-> n.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(newNams);
    }

    /*
     * stream 和 lambda 可能导致计算失效
     */
    private static void badUseLambda(){
        List<String> names = Arrays.asList("qiyi","21");

        int longestNameSize = names.stream()
                .filter(s -> s.startsWith("q"))
                .mapToInt(String::length)
                .max()
                .getAsInt();

        int longest = 0;

        for (String str: names) {
            if(str.startsWith("q")){
                int len = str.length();
                longest = Math.max(len,longest);
            }
        }
    }

}
