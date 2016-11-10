package dsa.list;

import dsa.node.Position;

import java.util.NoSuchElementException;

/**
 * Created by ASUS on 2016/11/7.
 */
/*
*  基于列表实现的位置迭代器
* */
public class IteratorPosition implements Iterator {

    private List list;
    private Position nextPosition;

    //默认构造方法
    public IteratorPosition(){
        list = null;
    }

    //构造方法
    public IteratorPosition(List l){
        list = l;
        if(list.isEmpty())
            nextPosition  = null;
        else
            nextPosition = list.first();
    }

    @Override
    public boolean hasNext() {
        return (nextPosition!=null);
    }

    @Override
    public Object getNext() {
        if(!hasNext())
            throw new NoSuchElementException("意外：没有下一位置");
        Position currentPosition = nextPosition;
        if(currentPosition == list.last()){
            nextPosition = null;
        }else{
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition;
    }
}
