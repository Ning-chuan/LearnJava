package com.ziyan.demo1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
    public static void main(String[] args){
        //获取Java线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程，不需要获取同步 monitor 和 synchronizer 信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for(ThreadInfo threadInfo:threadInfos){
            System.out.println("线程id：" + threadInfo.getThreadId() + " 线程名字：" + threadInfo.getThreadName());
        }
    }
}
