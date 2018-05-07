package collection_Demo;

import java.util.ArrayList;
/*
 * 作者:
 * 日期:2016年11月27日:下午6:03:50
 * 程序作用:
**/
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Map_4_sort {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("KFC", 1);
        map.put("NBA", 2);
        map.put("CBA", 3);
        // 变成list用list排序
        List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        // 排序  升序排列
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue() - o2.getValue());
            }
        });
        // 排序后
        for (int i = 0; i < infoIds.size(); i++) {
            String id = infoIds.get(i).toString();
            System.out.println(id);
        }
    }

}
