public class Test0101 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,};
        String result = binarySearch(array,6);
        System.out.println(result);
    }
    public static String binarySearch( int[] x, int num){
        int left = 0;
        int right = x.length-1;
        String result = "您要找的元素在数组中不存在";
        while(left<=right){
            int mid = (left+right)/2;
            if(num<x[mid]){
                right = mid-1;
            }else if(num>x[mid]){
                left = mid+1;
            }if(num==x[mid]){
                result = "您要找的元素在数组中的索引为"+mid;
                break;
            }
        }
        return result;
    }
}
