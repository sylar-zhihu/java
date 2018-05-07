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

public class Map_5_value_max_min {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 8);
        map.put("b", 12);
        map.put("c", 53);
        // map.put(123, 33);
        // map.put(42, 11);
        // map.put(44, 42);
        // map.put(15, 3);

        // System.out.println(getMinKey(map));
        System.out.println(getMaxValue(map));

    }

    /**
     * 求Map<K,V>中Key(键)的最小值
     * 
     * @param map
     * @return
     */
    public static Object getMinKey(Map<String, Integer> map) {
        if (map == null)
            return null;
        Set<String> set = map.keySet();
        Object[] obj = set.toArray();
        Arrays.sort(obj);
        return obj[0];
    }

    /**
     * 求Map<K,V>中Value(值)的最小值
     * 
     * @param map
     * @return
     */
    public static Object getMaxValue(Map<String, Integer> map) {
        if (map == null)
            return null;
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[obj.length - 1];
    }

    /**
     * 用途说明：根据value来排序
     */
    public static void SordByValue() {

        Map<String, Integer> map = new HashMap<String, Integer>();

        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> o1,

                    Map.Entry<String, Integer> o2) {

                return (o2.getValue() - o1.getValue());

            }

        });

    }

}
