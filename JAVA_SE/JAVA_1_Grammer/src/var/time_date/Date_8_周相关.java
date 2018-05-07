package var.time_date;

import java.util.Calendar;
import java.util.Date;

/*
 * 作者:
 * 日期:2016年11月30日:下午2:41:31
 * 程序作用:这个类有比Date类更多的处理时间的方法,不过太麻烦
**/
public class Date_8_周相关 {

    public static void main(String[] args) {
        // 没法new
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        // 需要一个date 对象
        calendar.setTime(new Date(date.getTime()));
        // 得到月份 月份从0开始 所以要加一 坑爹
        System.out.println(calendar.get(Calendar.MONTH));// 10
        // 得到年份
        int s;
        int aaaa = calendar.get(Calendar.YEAR);
        s = aaaa; // 得到年
        System.out.println(s);
        

    }

}
