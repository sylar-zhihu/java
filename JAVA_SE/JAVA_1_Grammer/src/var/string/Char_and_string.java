package var.string;

public class Char_and_string {

	public static void main(String[] args) {
		// 把char转为String
		char [] chars={'s', 'g', 'k'};
		String str=new String(chars);// 构造函数
		System.out.println(str);
		String str2 = String.valueOf(chars);// 调用方法
		System.out.println(str2);
		// 把String转为数组
		String str3="abcf123";
		char[] ch=str3.toCharArray();
		System.out.println(ch);
	}
}
