package rely;

public class Pig {
    public Pig(){}
    public Pig(String name){
        this.name = name;
    }
    private String name;
    private int weight = 20;
    public void grow(int month){
        for(int i=1;i<=month;i++){
            weight+=10;
        }
    }
    public void beKilled(){
        System.out.println(this.name+"被杀了，好惨一个猪");
    }
    public String getName(){
        return this.name;
    }
    public int getWeight(){
        return this.weight;
    }
}
