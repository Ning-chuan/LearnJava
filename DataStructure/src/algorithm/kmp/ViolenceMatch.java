package algorithm.kmp;

public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "我爱你爱你不爱你了";
        String str2 = "你了";
        int i = violenceMatch(str1, str2);
        System.out.println(i);
    }


    /**
     * 判断str1中是否含有str2
     * 如果有，返回第一次出现的坐标；如果没有返回-1。
     */
    public static int violenceMatch(String str1, String str2) {
        int i = 0;//str1指针
        int j = 0;//str2指针
        int len1 = str1.length();//str1长度
        int len2 = str2.length();//str2长度
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }
}
