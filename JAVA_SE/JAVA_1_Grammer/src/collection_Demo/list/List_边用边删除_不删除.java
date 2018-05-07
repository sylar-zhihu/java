package collection_Demo.list;

import java.util.ArrayList;
import java.util.List;

/*
 * 作者:
 * 日期:2017年5月8日:上午9:52:07
 * 程序作用:不删除程序无法执行完
**/
public class List_边用边删除_不删除 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 70000000; i++) {
            if (i % 100000 == 0) {
                System.out.println(i);
            }
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 100000 == 0) {
                System.out.println(i);
            }
            list2.add(i);
        }

        System.out.println("down");

    }

}
