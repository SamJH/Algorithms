package dsa.queue;

/**
 * Created by ASUS on 2016/11/3.
 */
public class ExceptionQueueFull extends RuntimeException{
    public ExceptionQueueFull(String err){
        super(err);
    }
}
