package collection_Demo;

import java.util.ArrayList;
/*
 * 作者:
 * 日期:2016年11月27日:下午6:03:50
 * 程序作用:遍历删除
**/
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map_6_iterator_remove {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 8);
        map.put("b", 12);
        map.put("c", 53);
        // 删除
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            if (key.equals("a")) {
                it.remove();
            }else{// 修改
                entry.setValue(55);
            }

        }
        // 把a删除掉了
        entrySet= map.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        

    }

    

}
