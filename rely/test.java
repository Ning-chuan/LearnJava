package rely;

public class test {
    public static void main(String[] args) {
        farmer luZhiShen = new farmer();
        pig peiQi = luZhiShen.feedPig(5);
        butcher wuSong = new butcher();
        wuSong.killPig(peiQi);
    }
}
