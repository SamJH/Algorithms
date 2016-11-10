package dsa.sequence;

import dsa.list.ExceptionPositionInvalid;
import dsa.list.List_DLNode;
import dsa.node.DLNode;
import dsa.node.Position;
import dsa.vector.ExceptionBoundaryViolation;

/**
 * Created by ASUS on 2016/11/7.
 */
/*
*    基于双向链表实现序列
*/
public class Sequence_DLNode extends List_DLNode implements Sequence{

    protected void checkRank(int r,int n)throws ExceptionBoundaryViolation{
        if(r<0||r>=n)
            throw new ExceptionBoundaryViolation("意外：非法的秩"+r+"应该属于（0,"+n+")");
    }

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r,getSize());
        return rank2Pos(r).getElem();
    }

    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        checkRank(r,getSize());
        DLNode node = (DLNode) rank2Pos(r);
        Object oldObj = node.getElem();
        node.setElem(obj);
        return oldObj;
    }

    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        checkRank(r,getSize()+1);
        if(getSize() == r)insertLast(r);
        else insertBefore(rank2Pos(r),obj);
        return obj;
    }

    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r,getSize());
        return remove(rank2Pos(r));
    }

    @Override
    public Position rank2Pos(int r) throws ExceptionBoundaryViolation {
        DLNode node;
        checkRank(r,getSize());
        if(r<=getSize()/2){
            node = header.getNext();
            for(int i=0;i<r;i++){
                node = node.getNext();
            }
        }else{
            node = trailer.getPrev();
            for(int i=0;i<getSize()-r;i++){
                node = node.getPrev();
            }
        }
        return node;
    }

    @Override
    public int pos2Rank(Position p) throws ExceptionBoundaryViolation {
        DLNode node = header.getNext();
        int r = 0;
        while (node != trailer) {
            if (node == p) {
                return r;
            }
            node = node.getNext();
            r++;
        }
        throw new ExceptionBoundaryViolation("意外：作为参数的位置不属于序列");
    }
}

