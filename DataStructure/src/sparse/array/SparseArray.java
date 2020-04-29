package sparse.array;

public class SparseArray {
    //稀疏数组
    public static void main(String[] args){
        //创建一个11*11的棋盘(二维数组)
        //其中第三行第四列有一个白子 第四行第五列有一个黑子
        //白子用1表示 黑子用2表示 空白用0表示
        int[][] chessArr = new int[11][11];
        chessArr[2][3] = 1;
        chessArr[3][4] = 2;
        //遍历展示棋盘
        System.out.println("创建的棋盘如下：");
        for(int[] rowArr:chessArr){
            for(int data:rowArr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //把上面的棋盘存在一个稀疏数组里
        //1  遍历找出棋盘中黑白子的个数 记录下来
        int num = 0;//记录黑白子个数
        for(int i = 0;i<chessArr.length;i++){
            for(int j = 0;j<chessArr[i].length;j++){
                if(chessArr[i][j]!=0){
                    num++;
                }
            }
        }
        //2  创建稀疏数组并存值
        int[][] sparseChessArr = new int[num+1][3];
        //   第一行存储： 总行数、总列数、黑白子总数
        sparseChessArr[0][0] = chessArr.length;
        sparseChessArr[0][1] = chessArr[0].length;
        sparseChessArr[0][2] = num;
        //   从第二行开始存储：每黑白子所在的行、列、值（黑/白）
        int count = 1;//行标记
        for(int i = 0;i<chessArr.length;i++){
            for(int j = 0;j<chessArr[i].length;j++){
                if(chessArr[i][j]!=0){
                    sparseChessArr[count][0] = i;
                    sparseChessArr[count][1] = j;
                    sparseChessArr[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }
        //遍历验证稀疏数组
        System.out.println("生成的稀疏数组如下：");
        for(int[] rowArr:sparseChessArr){
            System.out.printf("%d\t%d\t%d\t\n",rowArr[0],rowArr[1],rowArr[2]);
        }

        //根据稀疏数组还原成棋盘数组
        int rows = sparseChessArr[0][0];
        int columns = sparseChessArr[0][1];
        int nums = sparseChessArr[0][2];
        int[][] restoreChessArr = new int[rows][columns];
        for(int i = 1;i<=nums;i++){
            restoreChessArr[sparseChessArr[i][0]][sparseChessArr[i][1]] = sparseChessArr[i][2];
        }
        //展示还原后的棋盘数组
        System.out.println("还原后的棋盘如下：");
        for(int[] rowArr:restoreChessArr){
            for(int data:rowArr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
