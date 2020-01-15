public class ArrayBox {
    //设计一个类 替代数组可以做的事情
    //数组  长度是固定  存储一组元素
    //长度一旦固定 使用起来不太方便  添加元素  删除元素
    //设计一个类---充当一个小容器   ArrayBox
    //能添加元素  获取元素  删除元素  看一看到底有几个
    private static final int DEFAULT_CAPACITY = 10;
    private int[] initialArray;
    public ArrayBox(){
        initialArray = new int[DEFAULT_CAPACITY];
    }
    public ArrayBox(int capacity){
        initialArray = new int[capacity];
    }
    private int size = 0;//记录元素个数
    public boolean add(int element){
        this.ensureCapacityEnough(size+1);
        initialArray[size++] = element;
        return true;
    }
    public void remove(int index){
        this.rangeCheck(index);
        int value = initialArray[index];
        System.out.println("您要删除的索引对应的元素为："+value);
        //eg:{1,3,5,7,8,10,0,0,0,0}    要删除initialArray[3]
        for(int i=index;i<size-1;i++){
            initialArray[i] = initialArray[i+1];
        }
        initialArray[--size] = 0;
    }
    //============================================================
    private void ensureCapacityEnough(int minCapacity){
        if(minCapacity - initialArray.length>0){
            this.enlarge(minCapacity);
        }
    }
    private void enlarge(int minCapacity){
        int newCapacity = initialArray.length+(initialArray.length>>1);
        if(newCapacity<minCapacity){
            newCapacity = minCapacity;
        }
        initialArray = this.copyof(initialArray,newCapacity);
    }
    private int[] copyof(int[] oldArray,int newCapacity){
        int[] newArray = new int[newCapacity];
        for(int i=0;i<oldArray.length;i++){
            newArray[i] = oldArray[i];
        }
        return newArray;
    }
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            throw new BoxIndexOutOfBoundsException("index:"+index+",size:"+size);
        }
    }
    public int get(int index){
        this.rangeCheck(index);
        return initialArray[index];
    }
    public int size(){
        return this.size;
    }
}
