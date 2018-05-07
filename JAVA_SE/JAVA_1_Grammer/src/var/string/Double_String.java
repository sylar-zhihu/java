package var.string;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年11月17日:上午10:36:07
 * 程序作用:double可以解决这个问题
**/
public class Double_String {

    
    @Test
    public void TestTwo(){
        double a = 5500000000.5983;
        System.out.println(a);
        BigDecimal b = new BigDecimal(a);
        // 转成String 
        DecimalFormat df = new DecimalFormat("#.00");
//        a = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        // 显示完全没有任何问题
        System.out.println(df.format(a));// 5500000000.60
        
    }


}
