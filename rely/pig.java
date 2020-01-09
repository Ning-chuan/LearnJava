package rely;

public class pig {
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
}
