package collection_Demo.copy;

import java.util.ArrayList;
import java.util.List;

/*
 * 作者:
 * 日期:2016年12月15日:下午3:02:10
 * 程序作用: 如果里面是string可以复制，但是里面是集合不行
**/
public class 浅拷贝 {

    public static void main(String[] args) {
        // list 用addAll
        // map 用putAll
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        List<String> list2 = new ArrayList<>(list1);// 把list1拷贝一份给list2
        list2.add("cc");
        System.out.println(list1.size());// 1
        System.out.println(list2.size());// 2

        // 如果里面的对象不是基础类型。无法拷贝。
        List<List<String>> list3 = new ArrayList<>();
        list3.add(new ArrayList<String>());
        // 对象拷贝了,但是是同一个对象,所以操作list3(0),list4(0)也会改变
        List<List<String>> list4 = new ArrayList<>(list3);
        list3.get(0).add("aaaa");
        list3.get(0).add("aaaa");
        list3.get(0).add("aaaa");
        list3.get(0).add("aaaa");
        System.out.println(list3.get(0).size());// 4
        System.out.println(list4.get(0).size());// 4
    }

}
