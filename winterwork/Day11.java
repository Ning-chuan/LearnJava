package winterwork;

public class Day11 {
    //4 验证回文字符串
    //https://leetcode-cn.com/problems/valid-palindrome/
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                builder.append(s.charAt(i));
            }
        }
        String s1 = builder.toString();
        String s2 = builder.reverse().toString();
        if(s1.equalsIgnoreCase(s2)){
            return true;
        }
        return false;
    }


    //5 压缩字符串
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

}
