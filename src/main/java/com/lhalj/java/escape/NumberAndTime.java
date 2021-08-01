package com.lhalj.java.escape;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * @author : 刘唯卿
 * @date : 9:27 2021/2/2
 * 数值计算和时间计算
 */
public class NumberAndTime {


    //scale 需要和小数位匹配
    private static void scaleProblen(){
        BigDecimal decimal = new BigDecimal("12.222");
//        BigDecimal result = decimal.setScale(2);
        BigDecimal result = decimal.setScale(2,BigDecimal.ROUND_UP);
        System.out.println(result);

    }

    //BigDecimal 做除法时出现除不尽的情况
    private static void divideProblem(){
//        System.out.println(new BigDecimal(40).divide(new BigDecimal(7)));
        System.out.println(new BigDecimal(40).divide(new BigDecimal(7),2,BigDecimal.ROUND_UP));
    }

    //SimpleDateFormat 可以解析大于/等于它定义的时间精度
    private static void formatPrecision() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String time_x = "2020-03-01 10:00:00";
        String time = "2020-03";
        System.out.println(sdf.parse(time_x));
        System.out.println(sdf.parse(time));


    }


    /**
     * SimplleDateFormat 存在线程安全问题
     */
    private static void threadSafety(){

    }

    public static void main(String[] args) throws Exception{
//        scaleProblen();
//        divideProblem();
        formatPrecision();

    }
}
