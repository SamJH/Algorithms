package dsa.stack;

import dsa.node.Node;

/**
 * Created by ASUS on 2016/11/1.
 */
/*               基于单链表实现栈                   */
public class Stack_List implements Stack{

    protected Node top;
    protected int size;

    public Stack_List(){
        top = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (top==null)?true:false;
    }

    @Override
    public Object top() throws ExceptionStackEmpty {
        if(isEmpty())
            throw new ExceptionStackEmpty("意外：栈空");
        return top.getElem();
    }

    @Override
    public void push(Object obj) {
        Node v = new Node(obj,top);
        top = v;
        size++;
    }

    @Override
    public Object pop() throws ExceptionStackEmpty {
        if(isEmpty())
            throw new ExceptionStackEmpty("意外：栈空");
        Object obj = top.getElem();
        top = top.getNext();
        size--;
        return obj;
    }
}
