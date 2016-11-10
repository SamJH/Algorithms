package dsa.queue;

/**
 * Created by ASUS on 2016/11/3.
 */
/*                队列                   */
public interface Queue {
    public int getSize();
    public boolean isEmpty();
    public Object front() throws ExceptionQueueEmpty;
    public void enqueue(Object obj)throws ExceptionQueueFull;
    public Object dequeue() throws ExceptionQueueEmpty;
    public void Traersal();
}
