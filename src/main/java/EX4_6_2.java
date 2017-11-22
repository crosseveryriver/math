/**
 * Created by Administrator on 2017/11/12.
 */
public class EX4_6_2 extends NonLinearIteration {
    public double getNext(double current) {
        double y = Math.pow(current,2) + 10 * Math.cos(current);
        double f = 2 * current - 10 * Math.sin(current);
        double result =  -1 * y / f + current;
        return result;
    }

    public static void main(String[] args) {
        EX4_6_2 newton = new EX4_6_2();
        double result = newton.iterateUntil(2,1.0e-7);
        System.out.println("习题4第6题Newton方法运行结果：\n" + result);
        System.out.println("迭代次数：" + newton.getStep());

    }
}
