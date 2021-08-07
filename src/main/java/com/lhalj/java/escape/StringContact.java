package com.lhalj.java.escape;

/**
 * 描述: 字符串拼接
 * 尽量不要去依赖编译器的对字符串拼接的优化
 */
public class StringContact {

    private static void easyContact(){
        String userNmae = "Qinyi";
        String age = "18";
        String job = "Developer";
        //编译器会对代码优化 下面会变成StringBuilder.append()的形式
        String info = userNmae + age + job;
        System.out.println(info);
    }

    private static void implicitUseStringBuilder(String[] values){
        String result = "";
        //每一次循环都会创建一个新的StringBuilder对象
        for (int i = 0; i < values.length;++i){
            result += values[i];
        }
        System.out.println(result);
    }

    private static void explicitUseStringBuilder(String[] values){

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length;++i){
            result.append(values[i]);
        }
        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        easyContact();
    }
}
