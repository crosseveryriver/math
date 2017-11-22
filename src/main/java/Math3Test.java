import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Math3Test {

    public static void main(String[] args) {
        RealMatrix matrix = new Array2DRowRealMatrix(new double[][]{
                {1,2,3,4},
                {2,3,4,1},
                {3,4,1,2},
                {4,1,2,3}
        });

        System.out.println(new LUDecomposition(matrix).getSolver().getInverse());
    }
}
