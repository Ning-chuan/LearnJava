package rely;

public class Farmer {
    public Pig feedPig(int month){
        Pig p = new Pig("佩奇");
        p.grow(month);
        return p;
    }
}
