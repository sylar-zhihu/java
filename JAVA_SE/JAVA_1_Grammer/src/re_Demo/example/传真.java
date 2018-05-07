package re_Demo.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2017年9月18日:下午5:02:12
 * 程序作用:
**/
public class 传真 {

    public static void main(String[] args) {
        
//        String tel="0576-82651228";
        String tel="www.lsmin.com我0576-82651228我我916111002217259967陕西炼石有色资源股份有限公司";
        Pattern p = Pattern.compile("((0\\d{2,3}-)?\\d{7,8})");
        
       
        
        
        Matcher matcher = p.matcher(tel);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

}
