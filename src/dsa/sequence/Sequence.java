package dsa.sequence;

import dsa.list.List;
import dsa.node.Position;
import dsa.vector.ExceptionBoundaryViolation;
import dsa.vector.Vector;

/**
 * Created by ASUS on 2016/11/7.
 */
/*
*  序列ADT接口
*/
public interface Sequence extends Vector,List {
    //若0<=r<getSize()，则返回秩为r的元素所在的位置
    public Position rank2Pos(int r)throws ExceptionBoundaryViolation;
    //若0<=r<getSize(),则返回位置为p的节点秩
    public int pos2Rank(Position p)throws ExceptionBoundaryViolation;
}
