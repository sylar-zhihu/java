package bao.myMath;

import java.util.Random;

/*
 * 作者:
 * 日期:2016年12月6日:上午9:40:36
 * 程序作用:
**/
public class Math_Random {

    public static void main(String[] args) {
        // 0-(n-1)的随机整数
        Random random = new Random();
        System.out.println(random.nextInt(10));

    }

}
