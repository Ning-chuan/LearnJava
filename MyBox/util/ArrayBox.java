package util;

public class ArrayBox implements Box{
    private static final int DEFAULT_CAPACITY = 10;
    //上一行中不直接给10 而要用静态常量是为了增加可读性
    private int size = 0;//记录有效元素
    private int[] elementData;
    public ArrayBox(){
        elementData = new int[DEFAULT_CAPACITY];
    }
    public ArrayBox(int capacity){
        elementData = new int[capacity];
    }
    private void ensureCapacityEnough(int minCapacity){
        if(minCapacity-elementData.length>0){
            this.enlarge(minCapacity);
        }
    }
    private void enlarge(int minCapacity){
        int newCapacity = elementData.length+(elementData.length>>1);
        //上一行设计了一个简单的算法，目的是不必让每次添加元素的时候都调用一次enlarge方法
        if(newCapacity-minCapacity<0){
            newCapacity = minCapacity;
        }
        elementData = this.copyOf(elementData,newCapacity);
    }
    private int[] copyOf(int[] oldArray,int capacity){
        int[] newArray = new int[capacity];
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
    //======================================================
    public boolean add(int element){
        this.ensureCapacityEnough(size+1);
        elementData[size++] = element;
        return true;
    }
    public int get(int index){
        this.rangeCheck(index);
        return elementData[index];
    }
    public int remove(int index){
        this.rangeCheck(index);
        int value = elementData[index];
        for(int i=index;i<size-1;i++){
            elementData[i] = elementData[i+1];
        }
        elementData[--size] = 0;
        return value;//将删除的元素返回，防止用户后悔
    }
    public int size(){
        return size;
    }
}
