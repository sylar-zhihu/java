package re_Demo.example;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:
**/
public class 替换_最后四位替换成星号 {

    public static void main(String[] args) {
        System.out.println("1991-2-2".replaceAll("\\d{4}$", "****"));
    }

}
