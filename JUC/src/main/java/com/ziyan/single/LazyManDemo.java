package com.ziyan.single;

public class LazyManDemo {
    public static void main(String[] args) {

    }
}

class LazyMan{
    //私有构造方法
    private LazyMan(){

    }
    private static LazyMan instance;
    public static LazyMan getInstance(){
        if(instance == null){
            instance = new LazyMan();
        }
        return instance;
    }
}
