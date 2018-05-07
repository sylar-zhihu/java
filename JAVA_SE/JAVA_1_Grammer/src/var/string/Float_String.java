package var.string;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年11月17日:上午9:44:18
 * 程序作用:float有精度问题，不要用
**/
public class Float_String {

    /**
     * 用途说明：float显示两位小数的问题
     */
    @Test
    public void TestTwo() {
        float a = 5000000000.5983f;
        System.out.println(a);
        BigDecimal b = new BigDecimal(a);
        // 转成String 
        DecimalFormat df = new DecimalFormat("#.00");
//        a = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        // 显示完全没有任何问题
        System.out.println(df.format(a));// 350000011687231490.00
    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        float a = 5000000000.00f;
//        // 存在一个无法正常显示的问题
//        System.out.println(a);// 5.0E9
//        BigDecimal b = new BigDecimal(a);
//        a = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
//        System.out.println(a);
//
//    }

}
