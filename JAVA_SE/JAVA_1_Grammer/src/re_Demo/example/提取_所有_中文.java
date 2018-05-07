package re_Demo.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:
**/
public class 提取_所有_中文 {

    public static void main(String[] args) {
        String str = "aaa我来到北aa京清华大学     aa我来到北aa京清华大学";
        Pattern pattern = Pattern.compile("[\u4E00-\u9FA5]+");
        Matcher match = pattern.matcher(str);
        
        while (match.find()) {
                String matchStr = match.group(0);
                System.out.println(matchStr);
        }

    }

}
