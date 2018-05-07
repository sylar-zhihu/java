package var;

public class 八大基本类型不是Object的子类 {
	/*
	 * 八大基本类型不是Object的子类
	 * 转不成Object
	 */
	
	public static void main(String[] args) {
		int a=5;
		String b="ss";
		// 可以转换为Object
		Object object=b;
		// 不能转换会报错
//		Object object=a;

	}

}
