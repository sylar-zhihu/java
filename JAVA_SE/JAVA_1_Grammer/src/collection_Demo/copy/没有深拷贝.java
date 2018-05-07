package collection_Demo.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
 * 作者:
 * 日期:2016年12月15日:下午3:02:10
 * 程序作用: 如果里面是string可以复制，但是里面是集合不行,好像没有办法复制里面的集合
 * 自己自己写
**/
public class 没有深拷贝 {

    public static void main(String[] args) {
        // list 用addAll
        // map 用putAll
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        ArrayList<String> list2 =  (ArrayList<String>) list1.clone();
        list2.add("cc");
        System.out.println(list1.size());// 1
        System.out.println(list2.size());// 2
        
        // list里面的数据是共享的
        ArrayList<List<String>> list3 = new ArrayList<>();
        list3.add(new ArrayList<String>());
        ArrayList<List<String>> list4 = new ArrayList<>(list3);
//        ArrayList<List<String>>  list4 = (ArrayList<List<String>>) list3.clone();
        list3.get(0).add("aaaa");
        list3.get(0).add("aaaa");
        list3.get(0).add("aaaa");
        list3.get(0).add("aaaa");
        System.out.println(list3.get(0).size());// 4
        System.out.println(list4.get(0).size());// 4
    }

}
