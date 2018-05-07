package collection_Demo.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 作者:
 * 日期:2017年5月8日:上午9:52:07
 * 程序作用:不删除程序无法执行完,Iterator不能解决问题。。
**/
public class List_边用边删除_删除_Iterator没用 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 70000000; i++) {
            if (i % 100000 == 0) {
                System.out.println(i);
            }
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        int i=0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            i++;
            if (i % 100000 == 0) {
                System.out.println(i);
            }
            Integer val = it.next();
            list2.add(val);
           
                it.remove(); 
          
        }
       

        System.out.println("down");

    }

}
