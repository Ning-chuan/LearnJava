package winterwork;

public class Day1 {
    //4 实现函数 toLowerCase() 将给定字符串中的大写字母转换成小写字母 并返回
    public String toLowerCase(String str){
        char[] value = new char[str.length()];
        for(int i=0;i<str.length();i++){
            if(str.codePointAt(i)>=65 && str.codePointAt(i)<=90){
                value[i] = (char)(str.codePointAt(i)+32);
            }else{
                value[i] = str.charAt(i);
            }
        }
        return String.valueOf(value);
    }

    //5 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
    //输入: [1,2,3,4,5,6,7] 和 k = 3
    //输出: [5,6,7,1,2,3,4]
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        int index = 0;
        int[] newNums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i<k){
                newNums[i] = nums[nums.length-k+i];
            }else{
                newNums[i] = nums[index++];
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = newNums[i];
        }
    }

    //===================================================================
    public static void main(String[] args){
        Day1 test = new Day1();
//        String str = "A56INF89nL13Opfd";
//        String result = test.toLowerCase(str);
//        System.out.println(result);

        int[] nums = new int[]{1,2,5,6,8,9};
        test.rotate(nums,3);
        for(int v:nums){
            System.out.println(v);
        }
    }
}
