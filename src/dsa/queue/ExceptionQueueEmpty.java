package dsa.queue;

/**
 * Created by ASUS on 2016/11/3.
 */
public class ExceptionQueueEmpty extends RuntimeException{
    public ExceptionQueueEmpty(String err){
        super(err);
    }
}
