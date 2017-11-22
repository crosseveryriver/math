/**
 * Created by Administrator on 2017/11/12.
 */
public class EX6 {
    public static void main(String[] args) {
        double[][] Adata = new double[][]{
                {8.3,2.1,-1.2,0.5},
                {0.8,10.2,3.5,-1.8},
                {1.2,0.2,-4,-0.5},
                {-0.2,0.3,0.4,-2}
        };
        double[][] bdata = {{-3.02},{4.79},{-6.72},{8.89}};

        Matrix A = new Matrix(Adata);
        Matrix b = new Matrix(bdata);
        Matrix D = A.getDet();
        Matrix DInverse = D.inverseMatrix();
        Matrix BJ = DInverse.multiply(D.minus(A));
        Matrix gJ = DInverse.multiply(b);

        System.out.println(DInverse);

        Jacobi jacobi = new Jacobi(A,b);
        Matrix result = jacobi.iterateUntil(new Matrix(new double[][]{
                {0},
                {0},
                {0},
                {0}
        }),1.0e-6);
        System.out.println("第四题Jacobi计算结果：\n" + result);
        System.out.println("迭代次数：" + jacobi.getStep());
        System.out.println(jacobi.toString());

        System.out.println();
        Seidel seidel = new Seidel(A,b);
        result = seidel.iterateUntil(new Matrix(new double[][]{
                {0},
                {0},
                {0},
                {0}
        }),1.0e-6);
        System.out.println("第四题Seidel计算结果：\n" + result);
        System.out.println("迭代次数：" + seidel.getStep());

    }
}
