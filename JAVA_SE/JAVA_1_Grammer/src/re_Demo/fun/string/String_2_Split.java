package re_Demo.fun.string;

/*
 * 作者:
 * 日期:2016年11月30日:下午5:43:25
 * 程序作用:
**/
public class String_2_Split {

    public static void main(String[] args) {
        /*
         * String可以直接使用 不使用pattern
         */
        // 把句子按!分割
        String str = "Kevin has seen !seveal times,because ! film!";
        String[] result = str.split("!");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}
