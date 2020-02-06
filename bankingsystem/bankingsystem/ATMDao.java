package bankingsystem;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ATMDao {
    private FileLoadAndCommit flac = new FileLoadAndCommit();
    private HashMap<String,User> userBox = flac.loadFile("src\\bankingsystem\\UserData.txt");


    public User selectUser(String name){
        return this.userBox.get(name);
    }


    public void update(User user){
        this.userBox.put(user.getName(),user);
        flac.commit(userBox);
    }

    public void closeAccount(String name){
        this.userBox.remove(name);
        flac.commit(userBox);
    }
}
