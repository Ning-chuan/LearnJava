package com.ziyan.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo1 {

    //静态原子引用属性
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,1);
    
    public static void main(String[] args) {
        //线程一
        new Thread(()->{
            //获取版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(stamp);

            //睡一秒
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean res1 = atomicStampedReference.compareAndSet(1, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("引用1变为2同时升级版本号=>"+res1);
            boolean res2 = atomicStampedReference.compareAndSet(2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("引用2变为1同时升级版本号=>"+res2);

            
        }).start();

        //线程二
        new Thread(()->{
            //获取版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(stamp);
            
            //睡两秒
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean res = atomicStampedReference.compareAndSet(1, 6, stamp, stamp + 1);
            System.out.println("引用1变为6同时升级版本号=>"+res);//由于上面的线程修改了版本号，所以此时结果为false
            System.out.println("当前引用为："+atomicStampedReference.getReference()+"   当前版本号为："+atomicStampedReference.getStamp());

        }).start();
    }
}
