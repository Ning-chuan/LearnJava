package operatestream;

import java.io.*;

public class OperateStream {
    //1.设计一个方法  文件的复制
    //D://test//aaa.txt------->  E://某一个位置
    //找到D盘中的源文件   内容读一遍
    //去E盘中创建一个新文件  将内容写进去
//    public void copyFile(){
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            File file1 = new File("D://test//aaa.txt");
//            File file2 = new File("E://testE//eee.txt");
//            fis = new FileInputStream(file1);
//            fos = new FileOutputStream(file2,true);
//            file2.createNewFile();
//            int code = fis.read();
//            while(code!=-1){//code==-1时说明没有读取到字节
//                fos.write(code);
//                code = fis.read();//读取的是Unicode码
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if(fis!=null)fis.close();
//                if(fos!=null)fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    //2.设计一个方法  文件的加密/解密
    //		读取内容
    //		中间做一个小算法(加密)   可逆的
    //		写进去
    public void encryptFile(File file,String path){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File newFile = new File(path+"/"+file.getName());
            fis = new FileInputStream(file);
            fos = new FileOutputStream(newFile,true);
            byte[] b = new byte[2048];
            int count = fis.read(b);//count是读取到的有效字节个数
            while(count!=-1){//code==-1时说明没有读取到字节
                byte temp = b[0];
                b[0] = b[1];
                b[1] = temp;
                fos.write(b,0,count);
                fos.flush();
                count = fis.read(b);//接着往给定数组中度一次
            }
            System.out.println("加密完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //*3.扩展设计一个方法  文件夹的复制
    //		配合着递归
    //		配合着流
    public void copyFolder(File file,String path) {
        File newFile = new File(path+file.getAbsolutePath().split(":")[1]);
        File[] files = file.listFiles();
        if(files!=null){//数组不为null 说明是一个文件夹
            newFile.mkdirs();//第一步先创建文件夹
            if(files.length!=0){//长度不为零 说明不是空文件夹
                for(File v:files) {//遍历该文件夹的子File
                    this.copyFolder(v,path);//每一个子File都走一遍copyFolder()方法
                }
            }
        }else{//数组为null 说明file是一个文件 直接复制
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile,true);
                byte[] b = new byte[2048];
                int count = fis.read(b);
                while(count!=-1){
                    fos.write(b,0,count);
                    fos.flush();
                    count = fis.read(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(fis!=null)fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(fos!=null)fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void main(String[] args){
        OperateStream ts = new OperateStream();
        File file = new File("D:/test/B/Java第45课---工具类之StringBuffer+StringBuilder+Regex");
        ts.copyFolder(file,"E:/testE");
        //ts.copyFile();
        //ts.encryptFile();
        //ts.copyFolder(new File("D://test"),"E://tempTest");
    }
}
