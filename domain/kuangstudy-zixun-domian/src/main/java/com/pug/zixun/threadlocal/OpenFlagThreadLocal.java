package com.pug.zixun.threadlocal;

public class OpenFlagThreadLocal {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void put(Integer isFlag){
        threadLocal.set(isFlag);
    }
    public static Integer get(){
        return (Integer) threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }

}
