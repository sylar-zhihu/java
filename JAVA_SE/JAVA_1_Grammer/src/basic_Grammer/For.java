package basic_Grammer;

public class For {

	public static void main(String[] args) {
		/*
		 * 在for循环中i++和++i没有区别
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		for (int i = 0; i < 5; ++i) {
			System.out.println(i);
		}

	}

}
