package collection_Demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map_3_PutAll {

    public static void main(String[] args) {
        Map<String, String> hm = new HashMap<String, String>();
        Map<String, String> hm2 = new HashMap<String, String>();

        //  A.putAll(B)  B覆盖A的值 A一般会变大，B不会变。
        // 添加 key(object) value(object) 如果原来就有这个key 会返回原来的value
        hm.put("A", "A");// null
        hm.put("b", "B");// aValue
        hm.put("bKey", "bValue");
        hm2.put("b", "Bbbb");// aValue
        hm2.put("c", "Bbbb");// aValue
        System.out.println(hm.size());// 3
        System.out.println(hm2.size());// 2
        
//        hm2.putAll(hm);// hm2的值被hm的值覆盖
        hm.putAll(hm2);// hm的值被hm2的值覆盖。
        System.out.println(hm.size());// 4
        System.out.println(hm2.size());// 2
        Set<Entry<String, String>> entrySet = hm.entrySet();
        for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            
        }
    }

}
