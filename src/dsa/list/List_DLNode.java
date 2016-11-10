package dsa.list;

import dsa.node.DLNode;
import dsa.node.Position;
import dsa.vector.ExceptionBoundaryViolation;

/**
 * Created by ASUS on 2016/11/5.
 */
public class List_DLNode implements List {

    protected int numElem;
    protected DLNode header,trailer;

    public List_DLNode(){
        numElem = 0;
        header = new DLNode(null,null,null);
        trailer = new DLNode(null,header,null);
        header.setNext(trailer);
    }

    protected DLNode checkPosition(Position p)throws ExceptionPositionInvalid{
        if(null == p)
            throw new ExceptionPositionInvalid("意外：传递给List_DLNode的位置是空");
        if(header == p)
            throw new ExceptionPositionInvalid("意外：头节点哨兵违法");
        if(trailer == p)
            throw new ExceptionPositionInvalid("意外：为节点哨兵违法");
        DLNode temp = (DLNode)p;
        return temp;
    }

    @Override
    public int getSize() {
        return numElem;
    }

    @Override
    public boolean isEmpty() {
        return (0 == numElem) ? true : false;
    }

    @Override
    public Position first() {
        if(isEmpty())
            throw new ExceptionListEmpty("意外：列表空");
        return header.getNext();
    }

    @Override
    public Position last() {
       if(isEmpty())
           throw new ExceptionListEmpty("意外：队列空");
        return trailer.getPrev();
    }

    @Override
    public Position getPrev(Position p) throws ExceptionBoundaryViolation, ExceptionPositionInvalid {
        DLNode v = checkPosition(p);
        DLNode prev = v.getPrev();
        if(prev == header)
            throw new ExceptionBoundaryViolation("意外：企图越过列表前端");
        return prev;
    }

    @Override
    public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        DLNode v = checkPosition(p);
        DLNode next = v.getNext();
        if(next == trailer)
            throw new ExceptionPositionInvalid("意外：企图越过列表后端");
        return next;
    }

    @Override
    public Position insertFirst(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e,header,header.getNext());
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        return newNode;
    }

    @Override
    public Position insertLast(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e,trailer.getPrev(),trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        return newNode;
    }

    @Override
    public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosition(p);
        numElem++;
        DLNode newNode = new DLNode(e,v,v.getNext());
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
        return newNode;
    }

    @Override
    public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosition(p);
        numElem++;
        DLNode newNode = new DLNode(e,v.getPrev(),v);
        v.getPrev().setNext(v);
        v.setPrev(newNode);
        return newNode;
    }


    @Override
    public Object remove(Position p) throws ExceptionPositionInvalid {
        DLNode v = checkPosition(p);
        numElem--;
        DLNode vNext = v.getNext();
        DLNode vPrev = v.getPrev();
        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);
        Object element = v.getElem();
        v.setNext(null);
        v.setPrev(null);
        return element;
    }

    @Override
    public Object removeFirst() {
        return remove(header.getNext());
    }

    @Override
    public Object removeLast() {
        return remove(trailer.getPrev());
    }

    @Override
    public Object replace(Position p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosition(p);
        Object obj = v.getElem();
        v.setElem(e);
        return obj;
    }

    @Override
    public Iterator positions() {
       return new IteratorPosition(this);
    }
    @Override
    public Iterator elements(){
        return new IteratorElement(this);
    }
}
