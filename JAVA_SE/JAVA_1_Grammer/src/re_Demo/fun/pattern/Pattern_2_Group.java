package re_Demo.fun.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:找到某一部分
**/
public class Pattern_2_Group {

    public static void main(String[] args) {
        String str = "123456789";
        // 括号里面为分组
        Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            // 123456789 0下标是整个组
            System.out.println(matcher.group(0));
            // 123
            System.out.println(matcher.group(1));
            // 456
            System.out.println(matcher.group(2));
            // 789
            System.out.println(matcher.group(3));
        }

    }

}
