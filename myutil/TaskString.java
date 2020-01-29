package myutil;

public class TaskString {
    //1.设计一个方法 将字符串反转   ok-->ko
    public String reversal(String oldString){
        //方法一：
        return new String(new StringBuilder(oldString).reverse());

        //方法二：
//        char[] value = oldString.toCharArray();
//        for(int i=0;i<value.length/2;i++){
//            char temp = value[i];
//            value[i] = value[value.length-1-i];
//            value[value.length-1-i] = temp;
//        }
//        return String.valueOf(value);
    }

    //2.设计一个方法 将给定字符串的正序和反序进行连接  ok-->okko
    public String concatReversal(String oldString){
        String temp = this.reversal(oldString);
        return oldString.concat(temp);
    }

    //3.设计一个方法 判断给定字符串是否是回文    abccba   abcba
    public boolean isPalindrome(String target){
        if(this.reversal(target).equals(target)){
            return true;
        }
        return false;
//        boolean result = true;
//        char[] value = target.toCharArray();
//        for(int i=0;i<value.length/2;i++){
//            String x = String.valueOf(value[i]);
//            String y = String.valueOf(value[value.length-1-i]);
//            if(!x.equals(y)){
//                result = false;
//                break;
//            }
//        }
//        return result;
    }

    //4.设计一个方法 将给定的字符串右位移x位置 (helloworld,2)-->ldhellowor
    public String rightShift(String target,int count){
        count %= target.length();
        return target.substring(target.length()-count).concat(target.substring(0,target.length()-count));

//        String begin = target.substring(target.length()-count);
//        String end = target.substring(0,target.length()-count);
//        return begin.concat(end);

//        String temp = target.concat(target);
//        char[] value = temp.toCharArray();
//        char[] newValue = new char[target.length()];
//        count = count % newValue.length;
//        for(int i=0;i<newValue.length;i++){
//            newValue[i] = value[newValue.length-count+i];
//        }
//        temp = null;
//        value = null;
//        return String.valueOf(newValue);
    }

    //5.设计一个方法 寻找若干字符串中最长的那个  ab,abc,abcd--->abcd
    //改进后
    public String findMaxLengthString(String...strs){
        String target = strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()>target.length()){
                target = strs[i];
            }
        }
        return target;
    }
    //
//    public String longest(String[] strings){
//        String target = strings[0];
//        for(int i=1;i<strings.length;i++){
//            if(strings[i].length()>target.length()){
//                target = strings[i];
//            }
//        }
//        return target;
//    }

    //6.设计一个方法 统计给定字母在字符串中出现的次数
    // "this is a test of java","a"--->3
    public int leterExistCount(String str,char leter){
        //方法一
        return str.length()-str.replace(String.valueOf(leter),"").length();

        //方法二
//        int count = 0;
//        for(int i=0;i<str.length();i++){
//            if(leter==str.charAt(i)){//char是基本类型 可以直接比较
//                count++;
//            }
//        }
//        return count;
    }

    //7.设计一个方法 将给定的字符串每一个首字母大写
    //"this is a test of java"--->"This Is A Test Of Java"
    public String capitalEveryInitial(String str){
        //方法一
        char[] value = str.trim().toCharArray();
        value[0] = String.valueOf(value[0]).toUpperCase().charAt(0);
        for(int i=1;i<value.length;i++){
            if(String.valueOf(value[i]).equals(" ")){
                //String.valueOf(value[i+1]).toUpperCase();//不可行
                value[i+1] = String.valueOf(value[i+1]).toUpperCase().charAt(0);
            }
        }
        return String.valueOf(value);

//        //方法二
//        String[] words = str.trim().split(" ");
//        String result = "";
//        for(int i=0;i<words.length;i++){
//            String word = words[i];
//            word = word.substring(0,1).toUpperCase().concat(word.substring(1));
//            result = result.concat(word+" ");
//        }
//        return result.trim();
    }

    //8.设计一个方法 获取给定字符串中的全部数字 "za1o1zbp24tcq"--->1124
    public int getFigure(String str){
        //方法一：
        String result = "";
        for(int i=0;i<str.length();i++){
            if(str.codePointAt(i)>=48 && str.codePointAt(i)<=57){
                result+=(str.charAt(i));
            }
        }
        return Integer.parseInt(result);

        //方法二：
//        char[] value = str.toCharArray();
//        char[] figure = new char[str.length()];
//        int index = 0;
//        for(int i=0;i<str.length();i++){
//            switch(value[i]){//char int 类型都可以比较
//                case '0':
//                case '1':
//                case '2':
//                case '3':
//                case '4':
//                case '5':
//                case '6':
//                case '7':
//                case '8':
//                case '9':
//                    figure[index++] = value[i];
//            }
//        }
//        String figureString = new String(figure);
//        return figureString.trim();
    }
    //========================================================================

    public static void main(String[] args){
        TaskString ts = new TaskString();
        String str = "1234567";
        System.out.println(ts.reversal(str));
//        String str1 = ts.concatReversal(str);
//        System.out.println(str1);
//
//        System.out.println(ts.isPalindrome(str1));
//
//        System.out.println(ts.rightShift(str,3));
//
//        String longest = ts.findMaxLengthString("123","12345","12345678");
//        System.out.println(longest);

//        int num = ts.leterExistCount(str1,'q');
//        System.out.println(num);


//        String str = "this is a task of java learning ";
//        String result = ts.capitalEveryInitial(str);
//        System.out.println(result);

//        String str = "za1o1zbp24tcq";
//        int figure = ts.getFigure(str);
//        System.out.println(figure);
    }
}
