package dsa.node;

/**
 * Created by ASUS on 2016/11/3.
 */
/*                 双向链表                    */
public class DLNode implements Position{

    private Object element;
    private DLNode prev;
    private DLNode next;

    public DLNode(){
        this(null,null,null);
    }

    public DLNode(Object e,DLNode p,DLNode n){
        element = e;
        prev = p;
        next = n;
    }

    @Override
    public Object getElem() {
        return element;
    }

    @Override
    public Object setElem(Object e) {
        Object oldelem = element;
        element = e;
        return oldelem;
    }

    public DLNode getNext(){
        return next;
    }

    public DLNode getPrev(){
        return prev;
    }

    public void setNext(DLNode newNext){
        next = newNext;
    }

    public void setPrev(DLNode newPrev){
        prev = newPrev;
    }
}
