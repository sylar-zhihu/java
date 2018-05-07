package re_Demo.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2017年9月18日:下午4:16:56
 * 程序作用:
**/
public class 网址 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(http://|ftp://|https://|www){0,1}[^\u4e00-\u9fa5\\s]*?\\.(com|net|cn|me|tw|fr)[^\u4e00-\u9fa5\\s]*");
        // 空格结束
        Matcher matcher = pattern.matcher("随碟附送下载地址http://www.zuidaima.com/sdfsdf.htm?aaaa=%ee%sss ?sdfsyyy空格结束");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        // 中文结束
        matcher = pattern.matcher("随碟附送下载地址http://www.zuidaima.com/sdfsdf.htm?aaaa=%ee%sss网址结束");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        // 没有http://开头
        matcher = pattern.matcher("随碟附送下载地址www.zuidaima.com/sdfsdf.htm?aaaa=%ee%sss网址结束");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        // net域名
        matcher = pattern.matcher("随碟附送下载地址www.xxx.net/sdfsdf.htm?aaaa=%ee%sss网址结束");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        // xxx域名
        matcher = pattern.matcher("随碟附送下载地址www.zuidaima.xxx/sdfsdf.htm?aaaa=%ee%sss网址结束");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        // yyyy域名匹配不到
        System.out.println("匹配不到yyyy域名");
        matcher = pattern.matcher("随碟附送下载地址www.zuidaima.yyyy/sdfsdf.html?aaaa=%ee%sss网址结束");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        // 没有http://www.
        matcher = pattern.matcher("随碟附送下载地址zuidaima.com/sdfsdf.html?aaaa=%ee%sss网址结束");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        
        // 没有http://www.
        matcher = pattern.matcher("www.baidu.com");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }

}
