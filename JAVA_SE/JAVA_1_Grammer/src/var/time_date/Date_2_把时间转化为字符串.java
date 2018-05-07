package var.time_date;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 作者:
 * 日期:2017年1月20日:下午5:44:43
 * 程序作用:
**/
public class Date_2_把时间转化为字符串 {

    public static void main(String[] args) {
        // 当前时间
        Date date = new Date();
        System.out.println(date.getTime());// 1477988668153
        // 定义一个格式
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy年mm月dd日hh小时mm分钟ss秒EEE");
        SimpleDateFormat bartDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

        // 用bartDateFormat来输出想要的格式
        System.out.println(bartDateFormat.format(date)); // 2016年48月08日01小时48分钟29秒星期四
        System.out.println(bartDateFormat2.format(date));// 2017-01-20
        SimpleDateFormat bartDateFormat3 = new SimpleDateFormat("yyyy-M-d");
        System.out.println(bartDateFormat3.format(date));// 2017-1-20

    }

}
