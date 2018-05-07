package collection_Demo;

import java.util.ArrayList;
import java.util.List;

/*
 * 作者:
 * 日期:2016年12月13日:下午4:45:48
 * 程序作用:
**/
public class 传入到函数 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        addList(list);
        System.out.println(list.size());

    }

    private static void addList(List<String> list) {
        // TODO Auto-generated method stub
        list.add("aa");

    }

}
