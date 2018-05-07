package reflex_demo;

public class Fan_She_7_Array {
	/*
	 * Array也是一个类
	 * 根据类型不同来区分
	 */

	public static void main(String[] args) {
		int[] a1 = new int[3];
		int[] a2 = new int[4];
		int[][] a3 = new int[2][3];
		int[][] a33 = new int[6][8];
		String[] a4 = new String[3];
		a4.getClass();
		// 大小不同还是同一个类
		System.out.println(a1.getClass().toString().equals(a2.getClass().toString()));// true
		// 大小不同还是同一个类
		System.out.println(a3.getClass().toString().equals(a33.getClass().toString()));// true
		// 类型不同就不是一个类了
		System.out.println(a1.getClass().toString().equals(a4.getClass().toString()));// false
	}
}
