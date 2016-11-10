package dsa.vector;

/**
 * Created by ASUS on 2016/11/1.
 */
/*             向量                 */
public interface Vector {

    //获取向量长度
    public int getSize();

    //判断向量是否为空
    public boolean isEmpty();

    //获取秩为r的元素
    public Object getAtRank(int r) throws ExceptionBoundaryViolation;

    //将秩为r的元素替换为obj,并返回之前存放的元素
    public Object replaceAtRank(int r,Object obj) throws ExceptionBoundaryViolation;

    //插入obj，作为秩为r的元素，并返回该元素
    public Object insertAtRank(int r,Object obj) throws ExceptionBoundaryViolation;

    //删除秩为r的元素
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation;
}
