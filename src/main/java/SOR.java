/**
 * Created by Administrator on 2017/11/12.
 */
public class SOR extends Iteration {
    public SOR(Matrix A, Matrix b,double w) {
        super(A.getDet().add(A.getL().numberMultiply(w)).inverseMatrix().multiply(A.getDet().numberMultiply(1-w).minus(A.getR().numberMultiply(w))),
                A.getDet().add(A.getL().numberMultiply(w)).inverseMatrix().numberMultiply(w).multiply(b));
    }
}
