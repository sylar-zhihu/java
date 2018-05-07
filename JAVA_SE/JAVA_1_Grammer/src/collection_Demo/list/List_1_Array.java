package collection_Demo.list;

/*
 * array_list的用法
 */
// 集合类的包
import java.util.*;

public class List_1_Array {

	public static void main(String[] args) {
		// 泛型 ArrayList<E> E为arraylist里面元素的类型
		// 技巧：使用Collection ArrayList,LinkedList都可以用
		Collection<Person> collection = new ArrayList<Person>();
		Collection<Person> collection2 = new LinkedList<Person>();
		// 最好使用泛型告诉程序里面存的什么对象
		ArrayList<Person> arrayList1 = new ArrayList<Person>();
		ArrayList<Person> arrayList2 = new ArrayList<Person>();
		// 长度 arrayList.size()
		System.out.println(arrayList1.size());
		// 是否为空
		System.out.println(arrayList1.isEmpty());
		// 创建一个对象
		Person me1 = new Person("li1");
		Person me2 = new Person("li2");
		Person me3 = new Person("li3");
		// 添加对象
		arrayList1.add(me1);
		arrayList1.add(me2);
		arrayList1.add(me3);
		// 删除
		arrayList1.remove(0);// 可以使用下标
		arrayList1.remove(me2);// 可以使用对象
		arrayList1.remove("aa");// 没有不会报异常
		// 遍历
		Iterator<Person> it = arrayList1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// 得到第i个对象 get(index)
		System.out.println(arrayList1.get(0));
		// 清空所有数据
		arrayList1.clear();
		// 合并两个list addAll
		// add (index,obj) 原来的元素会被向后移动一个位置
		arrayList2.add(me1);
		arrayList2.add(me2);
		arrayList1.addAll(arrayList2);
		// constainsALL是不是包含另一个集合中所有元素
		// retainALL求交集
		// toArray() 转换成数组 是Object没啥用感觉
		// 输出 会调用每一个元素的toString方法
		System.out.println(arrayList1);// [Person@3ac803e6,Person@21780f30]
		// set 下标 元素 返回原有元素
		arrayList1.set(0, me1);
		// indexof(object) 第一次出现的位置
		// lastindexof(object)
		// 算法
		// sort 排序 shuffle 随机排序 reverse 倒序 binarySearch copy
	}

}

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

}