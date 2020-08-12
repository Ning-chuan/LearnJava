package com.ziyan.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
        /*
        Copy-On-Write，写入时复制
        平时查询的时候，都不需要加锁，随便访问
        只有在写入/删除的时候，才会从原来的数据复制一个副本出来，
        然后修改这个副本，最后把原数据替换成当前的副本。修改操作的同时，
        读操作不会被阻塞，而是继续读取旧的数据。这点要跟读写锁区分一下。
        */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);  
            },String.valueOf(i)).start();
        }
    }
}
