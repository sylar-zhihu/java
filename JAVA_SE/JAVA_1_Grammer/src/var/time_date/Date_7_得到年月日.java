package var.time_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 作者:
 * 日期:2016年11月30日:下午2:41:31
 * 程序作用:这个类有比Date类更多的处理时间的方法,不过太麻烦
**/
public class Date_7_得到年月日 {

    public static void main(String[] args) {
        // 没法new
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        // 需要一个date 对象
        calendar.setTime(new Date(date.getTime()));
        // 得到月份 月份从0开始 所以要加一 坑爹
        System.out.println(calendar.get(Calendar.MONTH));// 10
        // 得到年份
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);// 2017
        // 星期
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));// 3
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));// 10
        // 星期日是第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));// 4
        
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-M-d");
        // 用bartDateFormat来输出想要的格式
        System.out.println(bartDateFormat.format(date)); // 2016年48月08日01小时48分钟29秒星期四
        
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println(bartDateFormat.format(calendar.getTime())); 
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        System.out.println(bartDateFormat.format(calendar.getTime())); 

        

    }

}
