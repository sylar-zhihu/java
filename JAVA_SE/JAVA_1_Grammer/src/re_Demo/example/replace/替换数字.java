package re_Demo.example.replace;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:
**/
public class 替换数字 {

    public static void main(String[] args) {
        System.out.println("123456789".replaceAll("\\d{4}$", "****"));
    }

}
