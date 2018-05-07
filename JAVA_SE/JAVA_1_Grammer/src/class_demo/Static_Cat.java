package class_demo;

public class Static_Cat {
	/*
	 * 代码写法：
	 * 		可以只定义,也可以定义同时初始化
	 * 用途：
	 * 		全局共用的静态变量,可以用来计数,也可以单例模式
	 */
	static int sid = 1;
	int id;
	String name;

	public Static_Cat(String name) {
		this.name = name;
		id = sid++;
	}

	public static void main(String[] args) {
		Static_Cat cat1 = new Static_Cat("1");
		System.out.println(cat1.id);
		Static_Cat cat2 = new Static_Cat("2");
		System.out.println(cat2.id);
	}

}
