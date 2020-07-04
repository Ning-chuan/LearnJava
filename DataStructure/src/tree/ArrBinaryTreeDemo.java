package tree;

/**
 * 顺序存储二叉树
 *
 * 规律：左子节点索引 = 2*index+1
 *      右子节点索引 = 2*index+2
 *      父节点索引 = (index-1)/2
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        System.out.println("前序遍历：");
        tree.preOrder(0);//1,2,4,5,3,6,7
        System.out.println("中序遍历：");
        tree.infixOrder(0);//4,2,5,1,6,3,7
        System.out.println("后序遍历：");
        tree.postOrder(0);//4,5,2,6,7,3,1
    }
}
class ArrBinaryTree{
    private int[] arr;
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    //前序遍历
    /**
     * @param index 当前节点的索引
     */
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，无法遍历");
            return;
        }
        //1.输出当前索引节点
        System.out.println(arr[index]);
        //2.按照公式向左递归遍历 规律：左子节点索引 = 2*index+1
        if(2*index+1 < arr.length){
            preOrder(2*index+1);
        }
        //3.按照公式向右递归遍历 规律：右子节点索引 = 2*index+2
        if(2*index+2 < arr.length){
            preOrder(2*index+2);
        }
    }

    //中序遍历
    public void infixOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，无法遍历");
            return;
        }
        //1.按照公式向左递归遍历 规律：左子节点索引 = 2*index+1
        if(2*index+1 < arr.length){
            infixOrder(2*index+1);
        }
        //2.输出当前索引节点
        System.out.println(arr[index]);
        //3.按照公式向右递归遍历 规律：右子节点索引 = 2*index+2
        if(2*index+2 < arr.length){
            infixOrder(2*index+2);
        }
    }
    //后序遍历
    public void postOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，无法遍历");
            return;
        }
        //1.按照公式向左递归遍历 规律：左子节点索引 = 2*index+1
        if(2*index+1 < arr.length){
            postOrder(2*index+1);
        }
        //2.按照公式向右递归遍历 规律：右子节点索引 = 2*index+2
        if(2*index+2 < arr.length){
            postOrder(2*index+2);
        }
        //3.输出当前索引节点
        System.out.println(arr[index]);
    }
}
