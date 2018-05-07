package re_Demo.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2017年9月18日:下午5:23:51
 * 程序作用:
**/
public class Email {
    
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");
        // 空格结束
//        Matcher matcher = pattern.matcher("bzhao0697@sohu.com");
        Matcher matcher = pattern.matcher("  www.lsmin.com我0576-82651228我bzhao0697@sohu.com房我916111002217259967陕西炼石有色资源股份有限公司");
        
      
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
    
    

}
