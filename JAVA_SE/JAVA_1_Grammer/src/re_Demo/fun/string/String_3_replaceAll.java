package re_Demo.fun.string;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:
**/
public class String_3_replaceAll {

    public static void main(String[] args) {
        String string = "55554bb";
        // 第一个是正则,第二个是替换成什么
        String newStr = string.replaceAll("\\d+", "w");
        System.out.println(newStr);
        // 原来的字符不变
        System.out.println(string);

    }

}
