package var.string;
/*
 * 作者:
 * 日期:2016年12月7日:上午10:47:42
 * 程序作用:
**/
public class Split {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String string="aaaa";
        String[] split = string.split(" ");
        System.out.println(split.length);
        for (String string2 : split) {
            System.out.println(string2);
        }

    }

}
