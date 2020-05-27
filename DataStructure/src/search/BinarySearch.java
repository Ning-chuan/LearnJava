package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 9, 16, 25, 26, 33, 35};
        int res1 = binarySearch(arr, 0, arr.length - 1, 35);
        int res2 = insertValueSearch(arr,0,arr.length-1,35);
        System.out.println(res1+"----"+res2);

        /*
        int[] arr = new int[100];
        for(int i = 0;i < 100;i++){
            arr[i] = i+1;
        }
        System.out.println(insertValueSearch(arr,0,99,95));
        System.out.println(binarySearch(arr,0,99,95));
        System.out.println(4*6/12);
        System.out.println(6/12*4); // 6/12转成int的时候就是0了
        */
    }

    //
    private static int binarySearch(int[] arr, int left, int right, int num) {
        System.out.println("二分查找执行了");
        if (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < num) {
                return binarySearch(arr, mid + 1, right, num);
            } else if (arr[mid] > num) {
                return binarySearch(arr, left, mid - 1, num);
            } else {
                return mid;
            }
        }
        return -1;
    }

    //插值查找
    private static int insertValueSearch(int[] arr, int left, int right, int num) {
        System.out.println("插值查找执行了");
        if (left > right) {
            return -1;
        }
        int targetIndex = left + (right - left)*(num - arr[left]) / (arr[right] - arr[left]);
        if (arr[targetIndex] < num) {
            return insertValueSearch(arr, targetIndex + 1, right, num);
        } else if (arr[targetIndex] > num) {
            return insertValueSearch(arr,left,targetIndex-1,num);
        } else {
            return targetIndex;
        }
    }
}
