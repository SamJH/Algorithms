package dsa.queue;

/**
 * Created by ASUS on 2016/11/3.
 */
public class Josephus {
    public static Object Josephus(Queue Q,int k){
        if(Q.isEmpty()) return null;
        while(Q.getSize()>1){
            Q.Traersal();
            for(int i=0;i<k;i++){
                Q.enqueue(Q.dequeue());
                Object e = Q.dequeue();
                System.out.println("\n\t"+e+"退出");
            }
        }
        return Q.dequeue();
    }
    public static Queue buildQueue(Object a[]){
        Queue Q = new Queue_Array();
        for(int i=0;i<a.length;i++){
            Q.enqueue(a[i]);
        }
        return Q;
    }
    public static void main(String[] args){
        String[] kid = {};
        System.out.println("最终留下的孩子是:"+Josephus(buildQueue(kid),5));
    }
}
