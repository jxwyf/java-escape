package com.lhalj.java.escape;

import java.util.*;

/**
 * @author : 刘唯卿
 * @date : 16:07 2021/2/2
 * 如果不好好判等 集合存储就会乱套
 */
public class EqualOrElse {



    public static class User implements Comparable<User>{
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
                return this.name.equals(user.name) && this.age == user.age;
            }
            return false;
        }

        //hashCode默认返回内存地址
        @Override
        public int hashCode(){
            int result = name.hashCode();
            result = 31 * result+age;
            return result;
        }

        @Override
        public int compareTo(User o) {
            return (this.age - o.age) + this.name.compareTo(o.name);
        }
    }


    /**
     * 集合元素索引与 qeuals方法相关
     */
    private static void compareToAndEquals(){
        List<User> users = new ArrayList<>();
        users.add(new User("qiyi",10));
        users.add(new User("qiyi",20));

        User user = new User("qiyi",20);

        //获取元素索引的位置 基于equal方法的比较 用的是比较name
        int index1 = users.indexOf(user);
        //通过集合的方式获取索引 基于compareTo
        int index2 = Collections.binarySearch(users,user);
        System.out.println(index1);
        System.out.println(index2);
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

        System.out.println(userSet.size());
        System.out.println(userIntegerMap.size());
    }

    public static void main(String[] args) {

//        equalsAndHashcode();
        compareToAndEquals();
    }


}
