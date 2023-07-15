package com.pug.zixun.threadlocal;

import com.pug.zixun.domain.User;

public class UserThreadLocal {
    public static ThreadLocal<User> threadLocal = new ThreadLocal<>();
    public static void put(User user){
        threadLocal.set(user);
    }
    public static User get(){
        return threadLocal.get();
    }
    public static void remove(){
        threadLocal.remove();
    }
}
