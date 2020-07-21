package algorithm.dac;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    /**
     *
     * @param num 要处理的层数(盘数)
     * @param a  柱子
     * @param b  柱子
     * @param c  柱子
     *     默认盘全在a柱子上，要按大小顺序移动到c柱子上
     */
    public static void hanoiTower(int num,char a,char b,char c){
        if(num == 1){
            //如果只有一个盘，直接a->c
            System.out.println("第1个盘："+a+"->"+c);
        }else{
            //当num>=2时,看作两个盘，最下面的一个盘看作一个盘，上面的所有盘看作另一个盘
            //1.先把上面的所有盘 a->b   过程中需要用到c柱子
            hanoiTower(num-1,a,c,b);
            //2.把最下面的盘 a->c 过程中需要用到b柱子
            System.out.println("第"+num+"个盘："+a+"->"+c);
            //3.把b柱子上的盘移动到c 过程中需要用到柱子a
            hanoiTower(num-1,b,a,c);
        }
    }
}
