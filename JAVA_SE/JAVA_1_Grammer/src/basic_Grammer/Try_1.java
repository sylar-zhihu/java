package basic_Grammer;

public class Try_1 {

	public static void main(String[] args) {

		try {
			// 如果没有try 程序执行到这一句程序会停住
			// 有try会继续往后执行
			System.out.println(1 / 0);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("down");

	}

}
