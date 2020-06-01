package fileinput;

import java.io.*;

public class FileInputThread {
    public void read(){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(new File("D:\\test\\银行用户信息.txt"));
            bis = new BufferedInputStream(fis);
            //bis.read()
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
