package var.string;

import java.sql.Timestamp;

/*
 * 作者:
 * 日期:2016年11月30日:下午3:19:51
 * 程序作用:String 转date
**/
public class String_Date {

    public static void main(String[] args) {
        // 只能转这一种格式
        String string= "1970-2-2 12:22:22";
        //  Timestamp 继承date
        Timestamp valueOf = Timestamp.valueOf(string);
        System.err.println(valueOf);

    }

}
