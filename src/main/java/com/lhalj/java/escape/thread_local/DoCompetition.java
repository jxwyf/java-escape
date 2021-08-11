package com.lhalj.java.escape.thread_local;

/**
 * 描述:
 */
public class DoCompetition {

    public void code(){

        Competition.Material material = Competition.material.get();
        material.setCode(Thread.currentThread().getName());
        Competition.material.set(material);
    }

    public void config(){

        Competition.Material material = Competition.material.get();
        material.setConfig(Thread.currentThread().getName());
        Competition.material.set(material);
    }

    public void print(){
        System.out.println("线程名字:"+Thread.currentThread().getName());
        System.out.println("ThreadLocal hashcode:"+Competition.material.hashCode());
        System.out.println("Instance hashcode"+Competition.material.get().hashCode());
        System.out.println("value"+Competition.material.get().toString());
    }


}
