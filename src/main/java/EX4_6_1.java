/**
 * Created by Administrator on 2017/11/12.
 */
public class EX4_6_1 extends NonLinearIteration {
    public double getNext(double current) {
        double f = -1.0 * Math.pow(Math.E,current)/ 3  + 2.0 * current/ 3  - 1;
        double y = 2.0 / 3 - 1.0 * Math.pow(Math.E,current) / 3 + 1.0 * Math.pow(current,2) / 3  - current;
        double result =  -1 * y / f + current;
        return result;
    }

    public static void main(String[] args) {
        EX4_6_1 newton = new EX4_6_1();
        double result = newton.iterateUntil(0.25,1.0e-7);
        System.out.println("习题4第6题Newton方法运行结果：\n" + result);
        System.out.println("迭代次数：" + newton.getStep());
    }
}
