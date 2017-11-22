/**
 * Created by Administrator on 2017/11/12.
 */
public abstract class Iteration {
    private Matrix B;
    private Matrix g;
    private int step = 0;

    public Iteration(Matrix B, Matrix g) {
        this.B = B;
        this.g = g;
    }

    public Matrix iterateUntil(Matrix initial,double e){
        this.resetStep();
        Matrix current = initial;
        Matrix tmp = null;
        do{
            tmp = current;
            current = B.multiply(current).add(g);
            step ++;
        }while(tmp.minus(current).getInfiniteForm() > e);
        return current;
    }

    public int getStep(){
        return step;
    }

    private void resetStep(){
        this.step = 0;
    }

    @Override
    public String toString() {
        return B.toString() + "\r\n" + g.toString();
    }
}
