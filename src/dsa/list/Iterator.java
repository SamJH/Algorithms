package dsa.list;

/**
 * Created by ASUS on 2016/11/7.
 */
/*
*  迭代器
*/
public interface Iterator {
    boolean hasNext();         //检查迭代器中是否还有剩余的元素
    Object getNext();          //返回迭代其中的下一元素
}
