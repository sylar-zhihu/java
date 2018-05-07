package re_Demo.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2017年9月18日:下午4:33:30
 * 程序作用:
**/
public class 统一社会信用码 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9A-HJ-NPQRTUWXY]{2}\\d{6}[0-9A-HJ-NPQRTUWXY]{10}");
        // 空格结束
        Matcher matcher = pattern.matcher("陕西炼石有色资源股份有限公司www.baidu.com源916111002217259967");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

}
