package recursion;

public class MiGong {

    public static void main(String[] args) {
        //初始化地图
        int[][] map = new int[8][7];
        //设置墙壁
        //设置上、下墙壁
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //设置左、右墙壁
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置阻碍墙壁
        map[3][1] = 1;
        map[3][2] = 1;
        //map[2][2] = 1;

        //输出地图 预览一把
        System.out.println("地图如下：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

        //调用找路方法
        findWay(map,1,1,1,5);

        //输出路线地图
        System.out.println("找路之后地图如下：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

    }

    //递归找路方法
    //约定：0表示没有走过 1表示墙壁 2表示走过的路 3表示已经走过，但是走不通
    //map[i][j]表示起始位置  map[x][y]表示终点位置
    private static boolean findWay(int[][] map,int i,int j,int x,int y){
        if(map[x][y] == 2){
            //走到了终点 返回true 这里也是递归的出口
            return true;
        }else{
            if(map[i][j] == 0) {
                //当前位置没有走过
                //假设当前节点走得通 然后按照策略寻找
                map[i][j] = 2;
                //策略：寻找顺序为：下、右、上、左
                if (findWay(map, i + 1, j, x, y)) {
                    return true;
                } else if (findWay(map, i, j + 1, x, y)) {
                    return true;
                } else if (findWay(map, i - 1, j, x, y)) {
                    return true;
                } else if (findWay(map, i, j - 1, x, y)) {
                    return true;
                } else {
                    //四个方向都走不通 把当前位置标记为3 再返回false
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //当前位置可能的值为 1墙壁  2已经走过  3走不通 都不能走
                return false;
            }
        }
    }

}