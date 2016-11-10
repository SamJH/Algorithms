package dsa.queue;

/**
 * Created by ASUS on 2016/11/3.
 */
public class Queue_Array implements Queue{

    public static final int CAPACITY = 1024;
    protected int capacity;
    protected Object[] Q;
    protected int f = 0;
    protected int r = 0;

    public Queue_Array(){
        this(CAPACITY);
    }

    public Queue_Array(int cap){
        capacity = cap;
        Q = new Object[capacity];
    }

    @Override
    public int getSize() {
        return (capacity-f+r)%capacity;
    }

    @Override
    public boolean isEmpty() {
        return (f == r)?true:false;
    }

    @Override
    public Object front() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：队列空");
        return Q[f];
    }

    @Override
    public void enqueue(Object obj) throws ExceptionQueueFull {
        if(getSize() == capacity-1)
            throw new ExceptionQueueFull("意外：队列溢出");
            Q[r] = obj;
            r = (r+1)%capacity;
    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        if(isEmpty())
            throw new ExceptionQueueEmpty("意外：队列空");
        Object elem = Q[f];
        Q[f] = null;
        f = (f+1)%capacity;
        return elem;
    }

    @Override
    public void Traersal() {
        for(int i=f;i<r;i++){
            System.out.println(Q[i]+" ");
        }
    }
}
