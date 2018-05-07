package 类定义;

public class Static全局变量 {
	/*
	 * 代码写法：
	 * 		可以只定义,也可以定义同时初始化
	 * 用途：
	 * 		全局共用的静态变量,可以用来计数,也可以单例模式
	 */
	static int sid = 1;
	int id;
	String name;

	public Static全局变量(String name) {
		this.name = name;
		id = sid++;
	}

	public static void main(String[] args) {
		Static全局变量 cat1 = new Static全局变量("1");
		System.out.println(cat1.id);
		Static全局变量 cat2 = new Static全局变量("2");
		System.out.println(cat2.id);
	}

}
