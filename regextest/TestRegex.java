package regextest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args){
        String str = "123456bsdfgh567891adskjfhu635289asdf";
        Pattern pattern = Pattern.compile("\\d{6}");

        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
