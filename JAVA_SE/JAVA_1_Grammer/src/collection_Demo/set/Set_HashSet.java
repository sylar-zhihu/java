package collection_Demo.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
 * 作者:
 * 日期:2016年12月6日:下午5:04:28
 * 程序作用:set的使用
**/
public class Set_HashSet {

    public static void main(String[] args) {
        // 新建
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        // 添加
        set1.add("aa");
        set1.add("bb");
        set2.add("bb");
        // 差集 removeAll
        set1.removeAll(set2);
        System.out.println(set1.size());// 1
        // 并集 addAll
        set1.addAll(set2);
        System.out.println(set1.size());// 2
        // 交集
        set1.retainAll(set2);
        // 清空
        set1.clear();
        // 删除
        set1.remove("bb");

    }

}
