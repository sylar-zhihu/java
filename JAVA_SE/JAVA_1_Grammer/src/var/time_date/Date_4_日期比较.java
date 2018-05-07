package var.time_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 作者:
 * 日期:2016年12月8日:下午2:31:13
 * 程序作用:可以使用equals来比较是否为相同的一天。2009-06-01和2009-6-1是同一天。
**/
public class Date_4_日期比较 {

    public static void main(String[] args) {
        // 创建某一天的date
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat bartDateFormat2 = new SimpleDateFormat("yyyy-M-d");
        try {
            Date myDate1 = bartDateFormat.parse("2009-06-01");
            Date myDate2 = bartDateFormat2.parse("2009-6-1");
            System.out.println(myDate1.equals(myDate2));// 相等
            System.out.println(myDate1.before(myDate2));// 小于
            System.out.println(myDate1.after(myDate2));// 大于
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
