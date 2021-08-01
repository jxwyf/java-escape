package com.lhalj.java.escape;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : 刘唯卿
 * @date : 16:07 2021/2/2
 * 如果不好好判等 集合存储就会乱套
 */
public class EqualOrElse {

    public static class User {
        private String name;
        private Integer age;

        public User() {}

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof User){
                User user = (User) obj;
                return this.name.equals(user.name);
            }
            return false;
        }

        @Override
        public int hashCode(){
            int result = name.hashCode();
            result = 31 * result+age;

            return result;
        }

    }


    /**
     * 集合元素索引y与 qeuals方法相关
     */
    private static void compareToAndEquals(){

    }


    /**
     * 实现/不实现 equals 方法和hashcode对于判等的影响
     */
    private static void equalsAndHashcode(){
        User user1 = new User("qiyi",12);
        User user2 = new User("qiyi",12);
//        System.out.println(user1.equals(user2));

        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);

        Map<User,Integer> userIntegerMap = new HashMap<>();
        userIntegerMap.put(user1,0);
        userIntegerMap.put(user2,0);
    }

    public static void main(String[] args) {
        equalsAndHashcode();
    }


}
