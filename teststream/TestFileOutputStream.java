package teststream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:/testE/aaa.txt", true);
            String str = "1+2=3";
            byte[] b = str.getBytes();
            fos.write(b);//可以传byte 也可以传byte[]
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fos!=null)fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
