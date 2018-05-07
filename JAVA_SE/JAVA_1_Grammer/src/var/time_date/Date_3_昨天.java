package var.time_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 作者:
 * 日期:2016年12月12日:上午11:02:34
 * 程序作用:
**/
public class Date_3_昨天 {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();// 取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);// 把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        System.out.println(formatter.format(calendar.getTime()));


    }

}
