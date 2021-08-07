package com.lhalj.java.escape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:不要使用原始类型
 */
public class DoNotUseRawType {

    /*
     * 简单使用原始类型
     */
    private static void simpleExample(){
        List data = new ArrayList();
        data.add("qiyi");
        data.add(18);
        data.add("hello Imooc");

        //data.forEach(System.out::println);

        //data.forEach(d->{
        //    if(((String)d).equals("hello Imooc")){
        //        System.out.println(data.indexOf(d));
        //    }
        //});

        data.forEach(d->{
            if(d instanceof String && ((String)d).equals("hello Imooc")){
                System.out.println(data.indexOf(d));
            }
        });
    }

    /*
     * 优化使用原始类型
     * List<Object> data = new ArrayList();
     * 1.使用List<Object>至少明确告诉编译器 容器中可以存放任意类型的对象
     * 2. 明确指定具体的类型 把类型检查的工作交给编译器来完成
     */
    private static void optimizeUse(){
        //List<Object> data = new ArrayList();
        //data.add("qiyi");
        //data.add(18);
        //data.add("hello Imooc");
        //data.forEach(System.out::println);

        List<People> list = new ArrayList<>();

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class People{
        private String name;
        private Integer age;
        private String signature;
    }


    public static void main(String[] args) {
        simpleExample();
    }
}
