package re_Demo.fun.string;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:
**/
public class String_1_Matches {
    public static void main(String[] args) {

        // matches 完全匹配整个字符串是否完全匹配正则表达式
        // matches后面直接加正则表达式 返回true false

        System.out.println("a123".matches("\\d"));
        System.out.println("a".matches("."));
        System.out.println("aa".matches(".a"));
        // Java两个\\ 才表示一个\
        System.out.println("\\");// \
        System.out.println("123".matches("\\d"));// false \\d是一个数字
        System.out.println("aa".matches(".a"));

    }

}
