package com.lhalj.java.escape;

import java.util.Optional;

/**
 * @author : 刘唯卿
 * @date : 20:36 2021/2/1
 * 学会Optional 规避空指针异常
 */
public class OptionalUsage {


    public static class User {
        private String name;

        public String getName(){
            return name;
        }
    }

    private static void isUserEqualNull(){

        Optional<User> optional = Optional.empty();

        if(optional.isPresent()){
            System.out.println("User is not Null");
        }else {
            System.out.println("User is Null");
        }
    }

    private static User anyomos(){
        return new User();
    }

    public static void main(String[] args) {
        //没有意义的使用方法
        isUserEqualNull();

        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        //存在即返回 空则提供默认值
        optionalUser.orElse(new User());
        // 存在即返回 空则由函数去产生
        optionalUser.orElseGet(()->anyomos());
        //存在即返回 否则抛出异常
        optionalUser.orElseThrow(RuntimeException::new);

        //存在才去做相应的处理
        optionalUser.ifPresent(u-> System.out.println(u.getName()));

        //map 可以对Optional 中的对象执行某种操作 且会返回一个Optional对象
        optionalUser.map(u->u.getName()).orElse("anymos");

        //map 是可以无限级联操作的
        optionalUser.map(u->u.getName()).map(name->name.length()).orElse(0);

    }


}
