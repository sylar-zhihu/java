package collection_Demo;

import java.util.LinkedList;

public class 链表中的数组 {

	public static void main(String[] args) {
		/*
		 * 链表中的数组
		 */
		// 创建链表 里面装的是string数组
		LinkedList<String[]> stringList = new LinkedList<String[]>();
		String[] strs1 = { "AAA", "BBB", "CCC", "DDD" };
		String[] strs2 = { "111", "222", "333", "444" };
		String[] strs3 = { "!!!", "@@@", "###", "$$$" };
		// 加入元素
		stringList.add(strs1);
		stringList.add(strs2);
		stringList.add(strs3);
		
		for (String[] strs : stringList) {// 遍历链表
			for (String str : strs) {// 遍历数组
				System.out.println(str);
			}
		}

	}

}
