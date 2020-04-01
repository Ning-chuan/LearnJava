public class ReadRMB {
    private static String[] chNum = new String[]{"零","壹","二","叁","肆","伍","陆","柒","捌","玖"};
    private static String[] unit = {"十","百","千"};
    private static String[] decimalUnit = {"角","分"};

    //把一个数分成整数部分和小数部分 小数部分只保留两位
    private static String[] divide(float num){
        long integerPart = (long)num;
        long decimalPart = Math.round((num-integerPart)*100);
        return new String[]{integerPart+"",String.valueOf(decimalPart)};
    }

    //读一个四位数
    private static String readFour(String numStr){
        String result = "";
        int point = 0;
        for(int i=0;i<numStr.length();i++){
            if(numStr.charAt(point)=='0'){
                point++;
                continue;
            }
            if(i!=numStr.length()-1 && numStr.charAt(i)!='0'){
                //此时需要加单位
                result += chNum[numStr.charAt(i)-48]+unit[numStr.length()-i-2];
            }else {
                if(numStr.charAt(i) == '0'){//当前位是零
                    //判断是否后面的位都是零
                    int j=i;
                    while(j<numStr.length()) {
                        if(numStr.charAt(j)!='0'){
                            break;
                        }
                        j++;
                    }
                    if(j==numStr.length()){
                        //说明从当前位以后都是零 此时从当前位到最后都不用读了，直接结束循环
                        break;
                    }
                    //如果上面没有终断循环 将进行下面的判断
                    if(numStr.charAt(i - 1) == '0' || i==numStr.length()-1){
                        //如果当前位是零并且前一位还是零
                        //如果当前位是零并且当前位是最后一位
                        //当前位不用读 跳过看下一位
                        continue;
                    }
                }else{
                    result += chNum[numStr.charAt(i)-48];
                }
            }
        }
        return result.equals("")?"0":result;
    }

    //读取整数部分
    private static String readInteger(String integerPart){
        String result = "";
        int il = integerPart.length();
        if(il<5){
            result+=readFour(integerPart)+"元";
        }else if(il<9){
            result+=readFour(integerPart.substring(0,il-4))+"万";
            result+=readFour(integerPart.substring(il-4))+"元";
        }else if(il<13){
            result+=readFour(integerPart.substring(0,il-8))+"亿";
            result+=readFour(integerPart.substring(il-8,il-4))+"万";
            result+=readFour(integerPart.substring(il-4))+"元";
        }else{
            System.out.println("有你这么有钱的人吗");
        }
        return result;
    }
    //读取小数部分
    private static String readDecimal(String decimalPart){
        String result = "";
        for(int i=0;i<decimalPart.length();i++){
            if(decimalPart.charAt(i)!='0'){
                //不等于零必须读出来且必须加单位
                result+= chNum[decimalPart.charAt(i)-48]+decimalUnit[i];
            }else if(i==1 || (i==0 && decimalPart.charAt(1)=='0')){
                break;
            }else {
                result += chNum[decimalPart.charAt(i) - 48];
            }
        }
        return result;
    }

    //==========================================================================
    public static String readRMB(float money){
        String result = "";
        String[] nums = divide(money);
        String integerPart = readInteger(nums[0]);
        String decimalPart = readDecimal(nums[1]);
        if(integerPart.equals("")){
            result = null;
        }
        return result+=integerPart+decimalPart;
    }
}
