package com.lhalj.java.escape.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author : 刘唯卿
 * @date : 8:48 2021/2/2
 * 解决使用 try finally 的资源泄露隐患
 */
public class Main {


    /**
     * 传统的方式实现对资源的关闭
     */
    private String traditionalTryCatch() throws IOException{
        //1.单一资源的关闭
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader(""));
        try {
            line = br.readLine();
        }finally {
            br.close();
        }
        return line;
    }
}
