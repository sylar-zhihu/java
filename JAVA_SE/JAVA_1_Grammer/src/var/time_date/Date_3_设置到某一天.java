package var.time_date;
/*
 * 作者:
 * 日期:2017年2月15日:下午5:24:52
 * 程序作用:
**/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date_3_设置到某一天 {
    public static void main(String[] args) {
        SimpleDateFormat bartDateFormat3 = new SimpleDateFormat("yyyy-M-d");

        Calendar calendar = Calendar.getInstance();
        
        // // 设为当前月的1号 设置为几号就是几
        // calendar.set(Calendar.DATE, 1);
        // System.out.println(bartDateFormat3.format(calendar.getTime()));// 2017-2-1
        
        // 把年设置为1997
        // calendar.set(Calendar.YEAR, 1997);
        // System.out.println(bartDateFormat3.format(calendar.getTime()));// 1997-2-1
        
        // 得到当前周的，周X的日期
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        System.out.println(bartDateFormat3.format(calendar.getTime()));
    }

}
