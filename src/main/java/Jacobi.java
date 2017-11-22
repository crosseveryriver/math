/**
 * Created by Administrator on 2017/11/12.
 */
public class Jacobi extends Iteration {
    public Jacobi(Matrix A, Matrix b) {
        super(A.getDet().inverseMatrix().multiply(A.getDet().minus(A)),
                A.getDet().inverseMatrix().multiply(b));
    }
}
