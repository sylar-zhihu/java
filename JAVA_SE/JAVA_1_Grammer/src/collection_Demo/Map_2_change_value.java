package collection_Demo;

import java.util.HashMap;

/*
 * 作者:
 * 日期:2016年11月27日:下午5:34:38
 * 程序作用:
**/
public class Map_2_change_value {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 999);
        hashMap.put(2, 0);
        hashMap.put(3, 0);
        hashMap.put(4, 0);
        hashMap.put(5, 0);
        // 不能这样改 实际上并没有改变value的数字
        Integer integer = hashMap.get(1);
        integer += 1;
        System.out.println(hashMap.get(1));// 999
        // 只能重新插入
        hashMap.put(1, hashMap.get(1)+1);
        System.out.println(hashMap.get(1));// 1000
    }

}
