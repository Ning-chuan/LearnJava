package file;

import java.io.File;
import java.io.IOException;

public class Practice {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop//copy西部世界04.mp4");
        System.out.println(file.delete());
//        File file = new File("E://TestIO//A");
//        System.out.println(file.length());

//        File file = new File("E://TestIO//hello.txt");
//        System.out.println(file.listFiles());

        //renameTo()作用相当于剪切+改名
//        boolean res = file.renameTo(new File("E://TestIO//A"));
//        System.out.println(res);

//        try {
//            //createNewFile() 创建一个新文件 如果文件已存在则不创建 返回false
//            boolean res = new File("E://TestIO", "hello.txt").createNewFile();
//            System.out.println(res);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        File file = new File("E://TestIO//A");
//        delete(file);

//        File file = new File("D://Test");
//        long size = countFileSize(file);
//        System.out.println("文件大小为："+(size/1024/1024)+"M");
//        showFileName(file);

    }

    /**
     * 题目一：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
     */
    public static void delete(File file) {
        //1.判断是否是目录
        if (file.isDirectory()) {
            //2.获取子文件/目录数组
            String[] fileNames = file.list();
            if (fileNames != null && fileNames.length != 0) {
                for (String name : fileNames) {
                    if (name.endsWith(".jpg")) {
                        System.out.println(name);
                    }
                }
            }
        }
    }

    /**
     * 题目二：遍历指定目录所有文件名称
     */
    public static void showFileName(File file) {
        File[] files = file.listFiles();
        //条件：1.等于空说明是文件  2.长度为零说明是空文件
        if (files != null && files.length != 0) {
            for (File f : files) {
                showFileName(f);
            }
        } else {
            System.out.println(file);
        }
    }
    /**
     * 题目三（拓展）：计算指定目录占用空间的大小
     */
    public static long countFileSize(File file){
        long size = 0;
        File[] files = file.listFiles();
        //条件：1.等于空说明是文件  2.长度为零说明是空文件
        if(files != null && files.length != 0){
            for(File f:files){
                size += countFileSize(f);
            }
        }else{
            size += file.length();
        }
        return size;
    }


}
