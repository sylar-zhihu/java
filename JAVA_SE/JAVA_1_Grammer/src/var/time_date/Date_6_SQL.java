package var.time_date;

import java.util.Date;
/*
 * 作者:Lijianbo
 * 日期:2016年11月1日:下午4:23:06
 * 程序作用: 
 * 数据库里面的时间类型是java.sql.Date类型
 * DateTime类型，即需要年月日时分秒的，选择java.sql.Timestamp类型 
**/
public class Date_6_SQL {
    public static void main(String[] args) {
        // Date类型
        Date date = new Date();
        System.out.println(date.getTime());// 1477988668153
        
        //  存储 转换为Timestamp 一般数据库用这种类型
        java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
        System.out.println(dateTime);// 2016-11-01 16:50:20.875
        
    }

}
