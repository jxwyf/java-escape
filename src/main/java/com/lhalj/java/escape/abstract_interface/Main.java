package com.lhalj.java.escape.abstract_interface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 描述:java8 新增的静态方法和默认方法
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,7);
        int min = list.stream().min(Comparator.comparing(value ->value)).get();
        int max = list.stream().max(Comparator.comparing(value ->value)).get();
    }
}
