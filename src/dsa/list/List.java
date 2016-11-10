package dsa.list;

import dsa.node.Position;
import dsa.vector.ExceptionBoundaryViolation;

/**
 * Created by ASUS on 2016/11/5.
 */
/*                列表                   */
public interface List {
    public int getSize();
    public boolean isEmpty();
    public Position first();
    public Position last();
    public Position getPrev(Position p) throws ExceptionBoundaryViolation,ExceptionPositionInvalid;
    public Position getNext(Position p) throws ExceptionPositionInvalid,ExceptionBoundaryViolation;
    public Position insertFirst(Object e);
    public Position insertLast(Object e);
    public Position insertAfter(Position p,Object e) throws ExceptionPositionInvalid;
    public Position insertBefore(Position p,Object e) throws ExceptionPositionInvalid;
    public Object remove(Position p) throws ExceptionPositionInvalid;
    public Object removeFirst();
    public Object removeLast();
    public Object replace(Position p,Object e) throws ExceptionPositionInvalid;
    public Iterator positions();
    public Iterator elements();
}
