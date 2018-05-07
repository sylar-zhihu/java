package var.time_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 作者:
 * 日期:2017年1月20日:下午5:55:50
 * 程序作用:
**/
public class Date_5_解析字符串得到日期 {

    public static void main(String[] args) {
        // 定义格式
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat bartDateFormat2 = new SimpleDateFormat("yyyy-M-d");
        try {
            // 解析日期
            Date myDate1 = bartDateFormat.parse("2009-06-01");
            Date myDate2 = bartDateFormat2.parse("2009-6-1");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
