/**
 * Created by Administrator on 2017/11/12.
 */
public class Seidel extends Iteration {
    public Seidel(Matrix A, Matrix b) {
        super(A.getDet().add(A.getL()).inverseMatrix().numberMultiply(-1).multiply(A.getR()),
                A.getDet().add(A.getL()).inverseMatrix().multiply(b));
    }
}
