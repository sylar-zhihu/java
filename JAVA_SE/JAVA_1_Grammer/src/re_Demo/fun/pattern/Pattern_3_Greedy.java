package re_Demo.fun.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:
**/
public class Pattern_3_Greedy {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "<table>aa</table>aaaa<table>aa</table>";
        // 贪婪的正则
        Pattern pattern = Pattern.compile("<table>.*</table>");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        // <table>aa</table>aaaa<table>aa</table> 把.*贪婪了
        System.out.println(matcher.group());
        // 非贪婪 *+后面加一个?
        pattern = Pattern.compile("<table>.*?</table>");
        matcher = pattern.matcher(str);
        matcher.find();
        // <table>aa</table> 非贪婪
        System.out.println(matcher.group());
    }

}
