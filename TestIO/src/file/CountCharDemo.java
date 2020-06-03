package file;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 习题：统计一个文本文件中每种字符出现的个数
 */
public class CountCharDemo {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Administrator\\Desktop\\dbcp.txt";
        String countPath = "res.txt";

        countChar(filePath,countPath);
    }

    /**
     *
     * @param filePath  文本文件所在目录
     * @param countFilePath  生成的统计结果文件路径
     */
    public static void countChar(String filePath, String countFilePath) {
        //1.创建字符型文件读取流
        FileReader fr = null;
        //  1.1声明一个HashMap 用于记录每种字符出现的个数
        HashMap<Character, Integer> map = map = new HashMap<>();
        try {
            fr = new FileReader(new File(filePath));
            //2.读取文件 把读到的字符和次数存入map中
            int code;//记录每次读取到的字符对应的code码
            while ((code = fr.read()) != -1) {
                //转为字符
                char c = (char) code;
                if (map.get(c) != null) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //4.将map中的数据写入文件保存
        //  4.1创建一个字符型输出流
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(countFilePath)));
            //  4.2遍历所有数据
            Set<Character> keys = map.keySet();
            Iterator<Character> it = keys.iterator();
            while (it.hasNext()) {
                char c = it.next();
                switch (c) {
                    case ' ':
                        bw.write("空格=" + map.get(c));
                        break;
                    case '\t'://\t表示tab 键字符
                        bw.write("tab键=" + map.get(c));
                        break;
                    case '\r'://
                        bw.write("回车=" + map.get(c));
                        break;
                    case '\n'://
                        bw.write("换行=" + map.get(c));
                        break;
                    default:
                        bw.write(c + "=" + map.get(c));
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
