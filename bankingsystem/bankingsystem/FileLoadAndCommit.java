package bankingsystem;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileLoadAndCommit {

    public HashMap<String,User> loadFile(String path){//加载用户数据库
        HashMap<String,User> userBox = new HashMap<>();
        File file = new File("D:\\IdeaProjects\\BankingSystem\\src\\bankingsystem\\UserData.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String value = br.readLine();
            while(value!=null){
                String[] values = value.split("-");
                User user = new User(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]));
                userBox.put(user.getName(),user);
                value = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userBox;
    }


    //把修改提交到本地文件
    public void commit(HashMap<String,User> userBox){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter("D:\\IdeaProjects\\BankingSystem\\src\\bankingsystem\\UserData.txt");
            bw = new BufferedWriter(fw);
            Set<String> value = userBox.keySet();
            Iterator it = value.iterator();
            while(it.hasNext()){
                String name = (String)it.next();
                User user = userBox.get(name);
                StringBuilder builder = new StringBuilder(user.getName());
                builder.append("-");
                builder.append(user.getPassword());
                builder.append("-");
                builder.append(user.getBalances());
                bw.write(builder.toString());
                bw.newLine();
                bw.flush();
            }
            System.out.println("提交成功");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
