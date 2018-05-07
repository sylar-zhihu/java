package reflex_demo;

import java.lang.reflect.Array;

public class Fan_She_8_Array {
	/*
	 * 数组的反射
	 * 给一个对象 打印对象的内容
	 * 如果是一个Array就打印里面的内容
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void printObj(Object obj) {
		Class class1 = obj.getClass();
		if (class1.isArray()) {
			int len = Array.getLength(obj);
			for (int i = 0; i < len; i++) {
				System.out.println(Array.get(obj, i));
			}
		} else {
			System.out.println(obj);
		}

	}

}
