package util;

import java.util.HashMap;

public class ThreadLocalManager {

    private static HashMap<String,ThreadLocal> localMap= new HashMap<>();

    public static ThreadLocal getThreadLocal(String uname){
        ThreadLocal local = localMap.get(uname);
        if(local == null){
            local = new ThreadLocal();
            localMap.put(uname,local);
        }
        return local;
    }

}
