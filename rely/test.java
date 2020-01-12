package rely;

public class Test {
    public static void main(String[] args) {
        Farmer luZhiShen = new Farmer();
        Pig peiQi = luZhiShen.feedPig(5);
        Butcher wuSong = new Butcher();
        wuSong.killPig(peiQi);
    }
}
