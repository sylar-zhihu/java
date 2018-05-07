package var.time_date;

import java.util.Date;

/*
 * 作者:
 * 日期:2016年11月26日:下午5:18:00
 * 程序作用:
**/
public class Date_1_得到当前时间_不常用 {

    public static void main(String[] args) {
        // 两个的结果是一样的都是得到当前的毫秒数
        System.out.println(System.currentTimeMillis());// System.currentTimeMillis() 这种容易一些
        Date date = new Date();
        System.out.println(date.getTime());// 这种需要new Date 这种比较规范

    }

}
