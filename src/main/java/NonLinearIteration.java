/**
 * Created by Administrator on 2017/11/12.
 */
public abstract class NonLinearIteration {

    private int step = 0;

    public abstract double getNext(double current);

    public double iterateUntil(double initialValue,double e){
        step = 0;
        double current = initialValue;
        double tmp;
        do{
            tmp = current;
            current = getNext(current);
            step ++;
        }while(Math.abs(current - tmp) > e);
        return current;
    }

    public int getStep(){
        return step;
    }

}
