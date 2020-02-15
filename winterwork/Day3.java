package winterwork;

public class Day3 {
    //4 赎金信
    //给定一个赎金信(ransom)字符串和一个杂志(magazine)字符串，
    //判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
    //如果可以构成，返回 true；否则返回 false。
    //(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
    //可以假设两个字符串均只含有小写字母。
    //示例：
    //canConstruct("a", "b") -> false
    //canConstruct("aa", "ab") -> false
    //canConstruct("aa", "aab") -> true
    public boolean canConstruct(String ransomNote, String magazine) {
//        if (magazine.length() < ransomNote.length()){
//            return false;
//        }
//        int caps[] = new int[26];
//        for (char c : ransomNote.toCharArray()) {
//            int index = magazine.indexOf(c, caps[c - 'a']);
//            if (index == -1){
//                return false;
//            }
//            caps[c - 97] = index + 1;
//        }
//        return true;

        //方法二：
        StringBuilder stringBuilder = new StringBuilder(magazine);
        int index;
        for (char c : ransomNote.toCharArray()) {
            index = stringBuilder.indexOf(String.valueOf(c));
            if (index >= 0) {
                stringBuilder.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return true;
    }

    //5 判断一个整数是否是回文数。 指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean isPalindrome(int x) {
        //方法一：
//        String reverseNum = new StringBuilder(String.valueOf(x)).reverse().toString();
//        return reverseNum.equals(String.valueOf(x));

        //方法二：
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int reverseNum = 0;
        while(x>reverseNum){
            reverseNum = reverseNum*10+x%10;
            x/=10;
        }
        return x==reverseNum || x==reverseNum/10;
    }
}
