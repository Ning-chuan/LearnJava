package taskstream;

import java.io.*;

public class TaskStream {
    //1.设计一个方法  文件的复制
    //D://test//aaa.txt------->  E://某一个位置
    //找到D盘中的源文件   内容读一遍
    //去E盘中创建一个新文件  将内容写进去
    public void copyFile(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file1 = new File("D://test//aaa.txt");
            File file2 = new File("E://testE//eee.txt");
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2,true);
            file2.createNewFile();
            int code = fis.read();
            while(code!=-1){//code==-1时说明没有读取到字节
                fos.write(code);
                code = fis.read();//读取的是Unicode码
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(fis!=null)fis.close();
                if(fos!=null)fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //2.扩展设计一个方法  文件的加密/解密
    //		读取内容
    //		中间做一个小算法(加密)   可逆的
    //		写进去
    public void encryptFile(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file1 = new File("D://test//aaa.txt");
            File file2 = new File("D://test//encryptaaa.txt");
            file2.createNewFile();
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2,true);
            int code = fis.read();
            while(code!=-1){//code==-1时说明没有读取到字节
                fos.write(code+3);
                code = fis.read();//读取的是Unicode码
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(fis!=null)fis.close();
                if(fos!=null)fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //*3.扩展设计一个方法  文件夹的复制
    //		配合着递归
    //		配合着流
//    public void copyFolder(File file,String path){
//        File[] files = file.listFiles();
//        if(files!=null && files.length!=0) {
//            for(File v:files){
//                this.copyFolder(v,v.getPath());
//            }
//        }
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try{
//            fis = new FileInputStream(file);
//            File file1 = new File(path);
//            file1.createNewFile();
//            fos = new FileOutputStream(file1,true);
//            int code = fis.read();
//            while(code!=-1){
//                fos.write(code);
//                code = fis.read();
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            try {
//                if(fis!=null)fis.close();
//                if(fos!=null)fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public static void main(String[] args){
        TaskStream ts = new TaskStream();
        //ts.copyFile();
        //ts.encryptFile();
        ts.copyFolder(new File("D://test"),"E://tempTest");
    }
}
