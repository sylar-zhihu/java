package basic_Grammer;

public class Equals_2_String {
	/*
	 * String的equals被重写过
	 * 因而String的equals不是比较两个对象的内存地址
	 * 而是比较String的字符串内容是不是一样
	 */

	public static void main(String[] args) {
		// String对象会在池子中缓存 所以是一个对象
		String s1 = "Monday";
		String s2 = "Monday";
		if (s1 == s2) {
			System.out.println("相等");// 指向的是同一个对象
		}
		// 等
		String s3 = "Monday";
		String s4 = new String("Monday");// 调用new的时候会新建一个内存地址所以不想等
		if (s3 == s4) {
			System.out.println("s3 == s4");
		} else
			System.out.println("s3 != s4");
		if (s3.equals(s4))
			System.out.println("s3 equals s4");// 两个的内容是一样的
		else
			System.out.println("s3 not equals s4");
	}
}
