public class TestArrayBox {
    public static void main (String[] args){
        ArrayBox a = new ArrayBox(10);
        for(int i=1;i<13;i++){
            a.add(i*3);
        }
        System.out.println("有效元素个数为："+a.size());
        for(int i=0;i<a.size();i++){
            int value = a.get(i);
            System.out.print(value+" ");
        }
        //System.out.println("ArrayBox长度为："+a.initialArray.length);
        a.remove(10);
        for(int i=0;i<a.size();i++){
            int value = a.get(i);
            System.out.print(value+" ");
        }
    }
}
