package util;

public class LinkedBox implements Box{
    private Node first;
    private Node last;
    private int size;

    private void linkLast(int element){
        Node newNode = new Node(last,element,null);
        if(last==null){//证明这个链表没有使用过
            first = newNode;
        }else{
            last.next = newNode;
        }
        last = newNode;
        size++;//元素加一
    }
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            throw new BoxIndexOutOfBoundsException("index:"+index+"size:"+size);
        }
    }
    private Node node(int index){
        Node targetNode;
        if(index < (size>>1)){
            targetNode = first;
            for(int i=0;i<index;i++){
                targetNode = targetNode.next;
            }
        }else{
            targetNode = last;
            for(int i=size-1;i>index;i--){
                targetNode = targetNode.prev;
            }
        }
        return targetNode;
    }
    private int unlink(Node targetNode){
        int value = targetNode.item;
        Node prev = targetNode.prev;
        Node next = targetNode.next;
//        if(prev==null){//target是第一个
//            next = first;
//            next.prev = null;
//        }else if(next==null){//targetNode是最后一个
//            prev = last;
//            prev.next = null;
//        }else {
//            prev.next = next;
//            //使该节点的上一个节点指向该节点的下一个节点
//            next.prev = prev;
//            //使该节点的下一个节点指向该节点的上一个节点
//            prev = null;//断开该节点的前指向
//            next = null;//断开该节点的后指向
//        }
        if(prev==null){//当前node就是第一个
            first = next;
        }else{
            prev.next = next;
            targetNode.prev = null;
        }
        if(next==null){//当前node就是最后一个
            last = prev;
        }else{
            next.prev = prev;
            targetNode.next = null;
        }
        size--;
        return value;
    }
    //======================================================
    @Override
    public boolean add(int element) {
        this.linkLast(element);
        return true;
    }

    @Override
    public int get(int index) {
        this.rangeCheck(index);
        Node targetNode = this.node(index);
        return targetNode.item;
    }

    @Override
    public int remove(int index) {
        this.rangeCheck(index);
        Node targetNode = this.node(index);
        int value = this.unlink(targetNode);
        return value;
    }

    @Override
    public int size() {
        return size;
    }
}
