package com.lhalj.java.escape.copy_on_rite;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 描述:
 */
public class GoodListService {

    private static final List<String> goods = new CopyOnWriteArrayList<>();


    public static boolean cantains(String good){
        return goods.contains(good);
    }

    //往容器添加元素
    public static void addGood(String good){
        goods.add(good);
    }

    //往容器里批量添加元素
    public static void addGoods(List<String> goods){
        goods.addAll(goods);
    }



}
