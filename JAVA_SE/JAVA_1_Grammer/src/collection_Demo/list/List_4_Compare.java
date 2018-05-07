package collection_Demo.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Author:Lijianbo
 * date:2016年4月28日
 * time:上午10:10:10
**/
public class List_4_Compare implements Comparable<List_4_Compare> {
    String str;
    
    public List_4_Compare(String str) {
        this.str=str;
    }
    /*
     * 解决List里面排序的问题 实现Comparable接口
     */

    public static void main(String[] args) {
        List<Helper> list = new ArrayList<>();

        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                // TODO Auto-generated method stub
                return 0;
            }
        });

    }

    @Override
    public int compareTo(List_4_Compare o) {
        // 返回0表示相等 正数表示大于
        return 0;
    }

}
