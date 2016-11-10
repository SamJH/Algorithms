package dsa.list;

import dsa.node.Position;

import java.util.NoSuchElementException;

/**
 * Created by ASUS on 2016/11/7.
 */
/*
*  基于列表实现的元素迭代器
* */
public class IteratorElement implements Iterator{

    private List list;
    private Position nextPosition;

    public IteratorElement(){
        list = null;
    }

    public IteratorElement(List l){
        list = l;
        if(list.isEmpty())
            nextPosition = null;
        else
            nextPosition = list.first();
    }

    @Override
    public boolean hasNext() {
        return (nextPosition != null);
    }

    @Override
    public Object getNext() {
        if(!hasNext())
            throw new NoSuchElementException("意外：没有下一元素");
        Position currentPosition = nextPosition;
        if(currentPosition == list.last()){
            nextPosition = null;
        }else{
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition.getElem();
    }
}
