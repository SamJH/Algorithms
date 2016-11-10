package dsa.stack;

/**
 * Created by ASUS on 2016/11/1.
 */
/*              栈                  */
public interface Stack {
    public int getSize();
    public boolean isEmpty();
    public Object top() throws ExceptionStackEmpty;
    public void push(Object obj);
    public Object pop() throws ExceptionStackEmpty;
}
