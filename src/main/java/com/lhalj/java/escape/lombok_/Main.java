package com.lhalj.java.escape.lombok_;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Period;

/**
 * 描述:lombok工具的使用以及需要避免的坑
 */
public class Main {

    /*
     * lombok 第一个坑
     * 对象属性单字母驼峰 对象序列化会变小写
     * 代码不符合java语言规范 要避免
     */
    private static void singleAlphabetHump() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        Personal personal = new Personal();
        personal.setIPhone("8.1");
        //{"name":"null","userName":"null","iphone":"8.1"}
        System.out.println(mapper.writeValueAsString(personal));
        String json = "{\"name\":\"null\",\"userName\":\"null\",\"iPhone\":\"8.1\"}";

        Personal personal1 = mapper.readValue(json, Personal.class);

        System.out.println(personal1);
    }

    /*
     * lombok 第二个坑
     */
    private static void equalsAndHashCodeBug(){
        AppleComputer appleComputer1 = new AppleComputer(1,"mac",1l,"pick");
        AppleComputer appleComputer2 = new AppleComputer(2,"mac1",1l,"pick");
        System.out.println(appleComputer1.equals(appleComputer2));
    }


    public static void main(String[] args) throws Exception {
//        singleAlphabetHump();
        equalsAndHashCodeBug();
    }
}
