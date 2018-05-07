package collection_Demo.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 作者:
 * 日期:2017年5月8日:上午9:52:07
 * 程序作用:还是失败。
**/
public class List_边用边删除_删除_for {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 70000000; i++) {
            if (i % 100000 == 0) {
                System.out.println(i);
            }
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        int j=0;
        for (int i = 0, len = list.size(); i < len; ++i) {
            j++;
            if (j % 100000 == 0) {
                System.out.println(j);
            }
            list2.add(list.get(i));
            list.remove(i);
            len--;// 减少一个
            i--;// 如果不加会出现评论1楼所说的情况。

        }

        System.out.println("down");

    }

}
