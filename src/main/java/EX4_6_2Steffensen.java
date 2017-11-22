/**
 * Created by Administrator on 2017/11/12.
 */
public class EX4_6_2Steffensen extends NonLinearIteration {
    public double getNext(double current) {
        double x1 = Math.acos(-1.0 * Math.pow(current,2) / 10);
        double x2 =  Math.acos(-1.0 * Math.pow(x1,2) / 10);
        double result = x2 - Math.pow((x2 - x1),2) / (x2 - 2 * x1 + current);
        return result;
    }

    public static void main(String[] args) {
        EX4_6_2Steffensen steffensen = new EX4_6_2Steffensen();
        double result = steffensen.iterateUntil(2,1.0e-7);
        System.out.println("习题4第6题Steffensen方法运行结果：\n" + result);
        System.out.println("迭代次数：" + steffensen.getStep());

    }
}
