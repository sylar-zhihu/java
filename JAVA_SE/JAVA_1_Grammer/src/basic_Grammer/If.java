package basic_Grammer;

public class If {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		// TODO Auto-generated method stub
		if (a > b) {
			System.out.println("a");
			System.out.println("aa");
		} else {
			System.out.println("b");
			System.out.println("bb");
		}
		// 如果if后面只有一句话可以省略{}
		if (b > a)
			System.out.println("aa");
		else {
			System.out.println("b");
			System.out.println("bb");
		}
		// 如果有多句话不能省略，有else会报错，建议任何情况不要省略
		// 没有else第二句话任何情况下都会执行
		if (1 > 2)
			System.out.println("a");
		System.out.println("aa");

	}

}
