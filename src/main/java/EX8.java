/**
 * Created by Administrator on 2017/11/12.
 */
public class EX8 {
    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{
                {5,2,1},
                {-1,4,1},
                {2,-3,-4}
        });
        Matrix b = new Matrix(new double[][]{
                {5.2},
                {-6.2},
                {-4.9}
        });
        Matrix DL = A.getDet().add(A.getL());
        Matrix DLInverse = DL.inverseMatrix();
        SOR sor = new SOR(A,b,1.25);

        System.out.println("第8题SOR运行结果:\n" + sor.iterateUntil(new Matrix(new double[][]{{1},{1},{1}}),1.0e-6));
        System.out.println("迭代次数：" + sor.getStep());
    }
}
