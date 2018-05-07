package 类定义;

/*
 * 同名不同参，同一个方法不同的参数
 */
public class OverLoad {

    private int getMax(int a, int b) {
        // TODO Auto-generated method stub
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 参数类型不一样
    private double getMax(double a, double b) {
        // TODO Auto-generated method stub
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OverLoad overload = new OverLoad();
        double a, b;
        a = 3.5;
        b = 5.0;
        // 调用的时候会自动找到匹配的参数类型
        overload.getMax(a, b);

    }

}
