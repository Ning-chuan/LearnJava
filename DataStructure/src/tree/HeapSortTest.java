package tree;

public class HeapSortTest {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,33,24,-6,78,60,11,-66,5,55};
//        heapSort(arr);
//        for(int value : arr){
//            System.out.print(value+"  ");
//        }

        int[] arr = new int[800000];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*80000000);
        }

        long time1 = System.currentTimeMillis();
        heapSort(arr);
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);//八十万137毫秒  八百万2321毫秒  八千万数据29954毫秒
    }

    private static void heapSort(int[] arr) {
        //以升序为例 （需要将无序数组按大顶堆的规则重构）
        //1.首次重构数组 （大顶堆）
        //arr.length/2-1 是第一个非叶子节点  （首次重构，只能按照从下往上，从左至右的顺序调整）
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            composeBigTopHeap(arr, i, arr.length);
        }
        //循环进行交换 重构步骤 直到数组有序
        int temp;
        for (int j = arr.length - 1; j > 0; j--) {
            //2.堆顶值（最大值）和本次尾元素交换
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            //3.交换完毕 重构剩下的数组
            composeBigTopHeap(arr,0,j);
        }
    }

    //把数组构成大顶堆的方法 (将以i为根节点的子树调整成大顶堆)

    /**
     * @param arr    待处理数组
     * @param i      非叶子节点在数组中的索引
     * @param length 要对多少个元素继续调整
     */
    private static void composeBigTopHeap(int[] arr, int i, int length) {
        //保存当前叶子节点的值
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//k指向右子节点
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];//把较大的值赋给当前节点
                //因为k值赋给了i 可能导致以k节点的子树混乱 所以下次循环需要处理k节点的子树
                //处理之前 需要让i指向k
                i = k;//i指向k
            } else {
                //说明i节点的左右子节点都小于i节点 不用处理了 所以break
                break;
            }
        }
        arr[i] = temp;
    }


}
