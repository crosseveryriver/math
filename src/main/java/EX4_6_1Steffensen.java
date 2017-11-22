/**
 * Created by Administrator on 2017/11/12.
 */
public class EX4_6_1Steffensen extends NonLinearIteration {
    public double getNext(double current) {
        double x1 = 2.0 / 3 - 1.0 * Math.pow(Math.E,current) / 3 + 1.0* Math.pow(current,2) / 3;
        double x2 = 2.0 / 3 - 1.0 * Math.pow(Math.E,x1) / 3 + 1.0 * Math.pow(x1,2) / 3;
        double result = x2 - Math.pow((x2 - x1),2) / (x2 - 2 * x1 + current);
        return result;
    }

    public static void main(String[] args) {
        EX4_6_1Steffensen steffensen = new EX4_6_1Steffensen();
        double result = steffensen.iterateUntil(0.5,1.0e-7);
        System.out.println("习题4第6题Steffensen方法运行结果：\n" + result);
        System.out.println("迭代次数：" + steffensen.getStep());

    }
}
