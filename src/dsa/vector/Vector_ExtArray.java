package dsa.vector;

/**
 * Created by ASUS on 2016/11/1.
 */
/*             基于可扩展数组的向量实现                   */
public class Vector_ExtArray implements Vector{

    private int N = 8;
    private int n;
    private Object[] A;

    public Vector_ExtArray(){
        A = new Object[N];
        n = 0;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (0 == n) ? true:false;
    }

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
       if(0>r||r>=n)
           throw new ExceptionBoundaryViolation("意外：秩越界");
        return A[r];
    }

    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if(0>r||r>=n)
            throw new ExceptionBoundaryViolation("意外：秩越界");
        Object o = A[r];
        A[r] = obj;
        return o;
    }

    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
       if(0>r||r>n)
           throw new ExceptionBoundaryViolation("意外：秩越界");
        if(n>=N){
            N *= 2;
            Object B[] = new Object[N];
            for(int i=0;i<n;i++){
                B[i] = A[i];
            }
            A = B;
        }
        for(int i=n;i>r;i--){
            A[i] = A[i-1];
        }
        A[r] = obj;
        n++;
        return obj;
    }

    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        if(0>r||r>=n)
            throw new ExceptionBoundaryViolation("意外：秩越界");
        Object bak = A[r];
        for(int i=r;i<n;i++){
            A[i] = A[i+1];
        }
        n--;
        return bak;
    }
}
