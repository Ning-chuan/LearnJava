package bankingsystem;

import java.io.*;
import java.util.HashMap;

public class UserBox {
    private HashMap<String,User> userBox = new HashMap<String,User>();
    private File file = new File("D:/test/银行用户信息.txt");

    boolean saveToLocal(User u){
        this.userBox.put(u.getName(),u);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file,true);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
