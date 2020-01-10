package rely;

public class butcher {
    public void killPig(pig p){
        String pigName = p.getName();
        int pigWeight = p.getWeight();
        System.out.println("屠夫杀了体重为"+pigWeight+"的"+pigName);
        p.beKilled();
    }
}
