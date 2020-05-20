package recursion;

public class Queen8 {
    public static void main(String[] args) {
        Queen8 q = new Queen8(8);
        q.put(0);

        System.out.println("正确结果的个数为："+q.count);
        System.out.println("判断的次数为："+q.countJudge);

    }

    //表示需要放几个皇后
    int queenNum;
    //用数组存储皇后摆放位置  索引表示行数 每一位具体的值表示列数
    int[] arr;
    int count = 0;//答案个数
    int countJudge = 0;//判断次数

    public Queen8(int queenNum) {
        this.queenNum = queenNum;
        this.arr = new int[this.queenNum];
    }


    //
    public void put(int n){
        if(n == queenNum){
            printResult();//由于是数组存储的 所以此时第n个皇后已经ok
            count++;
            return;
        }
        //这个循环表示皇后要在每一列都试一遍
        for(int i = 0;i < queenNum;i++){
            //把皇后放在当前列上
            arr[n] = i;
            if(judge(n)){
                //表示当前的皇后位置ok 继续放置下一个皇后 开始递归
                put(n+1);
            }
        }
    }


    //判断当前皇后位置是否可行（无法攻击到之前摆放的皇后即为可行）
    private boolean judge(int n) {
        countJudge++;
        //利用for循环和之前的每一个皇后都做判断
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n] 表示在同一列
            //Math.abs(n-i) == Math.abs(arr[n]-arr[i]) 表示在同一斜线上 可以理解为斜率为1
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])) {
                return false;//可以攻击到 返回false
            }
        }
        //循环结束 表示之前的都不会攻击到 返回true
        return true;
    }

    //打印结果数组
    private void printResult(){
        for(int value:arr){
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
