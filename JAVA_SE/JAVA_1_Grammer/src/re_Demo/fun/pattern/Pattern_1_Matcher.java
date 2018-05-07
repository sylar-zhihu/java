package re_Demo.fun.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:Matcher 类
**/
public class Pattern_1_Matcher {

    public static void main(String[] args) {

        // Pattern要结合matcher使用 编译能够提高效率，不用用一次编译一次
        // 把complie(中的正则)编译成一个Pattern
        Pattern pattern = Pattern.compile("\\d+");

        // pattern要结合matcher使用 matcher里面有大量有用的信息
        // matcher() 后面加目标字符串 返回Boolean

        Matcher matcher = pattern.matcher("2333f2444f");

        // matchers方法完全匹配整个字符串,指针会移动, 如果不匹配会到不匹配的第一个字符停下来

        System.out.println(matcher.matches());// false
        // 重置指针 让指针指向开头
        matcher.reset();

        // find找到相同模式的子串 然后指针停到最后一个不匹配的位置 再次调用find会继续向后查找 

        while (matcher.find()) {
            // group返回匹配
            System.out.println(matcher.group());
            // 当次寻找开始和结束的下标
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }

    }

}
