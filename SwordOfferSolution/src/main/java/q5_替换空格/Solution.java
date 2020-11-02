package q5_替换空格;

public class Solution {
    //方法一：
    public String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

    //方法二：
    public String replaceSpace2(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }


}
