package dsa.queue;

/**
 * Created by ASUS on 2016/11/3.
 */
/*             双端队列             */
public interface Deque {

    public int getSize();
    public boolean isEmpty();
    public Object first()throws ExceptionQueueEmpty;
    public Object last()throws ExceptionQueueEmpty;
    public void insertFirst(Object obj);
    public void insertLast(Object obj);
    public Object removeFirst()throws ExceptionQueueEmpty;
    public Object removeLast()throws ExceptionQueueEmpty;
    public void Traversal();
}
