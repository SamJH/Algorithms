package dsa.queue;

import dsa.node.DLNode;

/**
 * Created by ASUS on 2016/11/3.
 */
/*              基于双向链表实现双端队列               */
public class Deque_DLNode implements Deque{

    protected DLNode header;
    protected DLNode trailer;
    protected int size;

    public Deque_DLNode(){
        header = new DLNode();
        trailer = new DLNode();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0)?true:false;
    }

    @Override
    public Object first() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：空");
        return header.getNext().getElem();
    }

    @Override
    public Object last() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：空");
        return trailer.getPrev().getElem();
    }

    @Override
    public void insertFirst(Object obj) {
        DLNode second = header.getNext();
        DLNode first = new DLNode(obj,header,second);
        header.setNext(first);
        second.setPrev(first);
        size++;
    }

    @Override
    public void insertLast(Object obj) {
        DLNode second = trailer.getPrev();
        DLNode first = new DLNode(obj,second,trailer);
        second.setNext(first);
        trailer.setPrev(first);
        size++;
    }

    @Override
    public Object removeFirst() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：空");
        DLNode first = header.getNext();
        DLNode second = first.getNext();
        Object obj = first.getElem();
        header.setNext(second);
        second.setPrev(header);
        size--;
        return obj;
    }

    @Override
    public Object removeLast() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：空");
        DLNode first = trailer.getPrev();
        DLNode second = first.getPrev();
        Object obj = first.getElem();
        second.setNext(trailer);
        trailer.setPrev(second);
        size--;
        return obj;
    }

    @Override
    public void Traversal() {
        DLNode p = header.getNext();
        while(p!=trailer){
            System.out.print(p.getElem()+"");
            p = p.getNext();
        }
    }
}
