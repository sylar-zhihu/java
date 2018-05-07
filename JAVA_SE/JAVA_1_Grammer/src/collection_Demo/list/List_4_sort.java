package collection_Demo.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 作者:
 * 日期:2017年9月14日:上午11:08:42
 * 程序作用:
**/
public class List_4_sort {

    public static void main(String[] args) {

        Helper h1 = new Helper("a");
        Helper h2 = new Helper("aa");
        Helper h3 = new Helper("aaa");
        // 导入数据
        List<Helper> list = new ArrayList<>();
        list.add(h2);
        list.add(h1);
        list.add(h3);
     
        // 这里参数写什么类型就是对什么类型排序
        Collections.sort(list, new Comparator<Helper>() {

            @Override
            public int compare(Helper o1, Helper o2) {// >0表示升序
                // TODO Auto-generated method stub
                if(o1.str.length() > o2.str.length()){
                    return 1;
                }else{
                    return -1;
                }
                
            }
        });
        for (Helper helper : list) {
            System.out.println(helper.str);
        }
    }

}
