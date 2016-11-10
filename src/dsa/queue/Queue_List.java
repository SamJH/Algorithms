package dsa.queue;

import dsa.node.Node;

/**
 * Created by ASUS on 2016/11/3.
 */
public class Queue_List implements Queue{

    protected Node head;
    protected Node tail;
    protected int size;

    public Queue_List(){
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0)?true:false;
    }

    @Override
    public Object front() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：队列空");
        return head.getElem();
    }

    @Override
    public void enqueue(Object obj) throws ExceptionQueueFull {
        Node node = new Node();
        node.setElem(obj);
        node.setNext(null);
        if(0==size){
            head = node;
        }else{
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：队列空");
        Object obj = head.getElem();
        head = head.getNext();
        size--;
        if(0==size)tail=null;
        return obj;
    }

    @Override
    public void Traersal() {
        Node p = head;
        while(null!=p){
            System.out.println(p.getElem()+"");
            p = p.getNext();
        }
    }
}
