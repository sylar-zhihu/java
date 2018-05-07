package collection_Demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * Author:Lijianbo
 * date:2016年4月27日
 * time:下午6:25:19
**/
public class Iterator_Remove {
	/*
	 * 在Iterator中不要用原来对象remove
	 * 在Iterator中元素会被锁住
	 */
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("asv");
		Iterator<String> it = collection.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			if (string.length() > 2) {
				// 不要使用collection.remove() 这样是最安全的
				it.remove();
			}

		}
		System.out.println(collection.size());

	}

}
