package basic_Grammer;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Fan_Xing_2 {

	public static void main(String[] args) throws Exception {
		/*
		 * 使用反射的方式往ArrayList<String>里面加int
		 * 证明：编译以后泛型没有保存
		 * 结论泛型是给编译器看的
		 */
		// 在类中使用泛型
		ArrayList<String> collection = new ArrayList<String>();
		collection.add("abc");
		Method method= collection.getClass().getMethod("add", Object.class);
		// 加入一个integer
		method.invoke(collection, 1);
		// 出异常了 
		System.out.println(collection.get(1));

	}

}
