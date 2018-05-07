package basic_Grammer;

public class Enum_Basic {
	/*
	 * 需求： 定义一个枚举类型 可以用MyColor 去定义变量 变量只能取red,green,blue 
	 * 好处： 可以更早的发现错误 myColor=0
	 * 会报错 不能用数字直接定义 public enum Color{red,green,blue}; 实际上是调用
	 * new Enum<Enum_Class>("red",0); 
	 * new Enum<Enum_Class>("green",1); 
	 * new Enum<Enum_Class>("blue",2);
	 */
	// 定义一个枚举
	public enum Color {
		red, green, blue
	};

	public static void main(String[] args) {

		System.out.println(Color.green.ordinal());// 1

		/*
		 * 常用的case方法 判断是枚举类型的哪一个变量
		 * 元素必须属于Color枚举
		 */
		Color myColor = Color.red;
		switch (myColor) {
		case red:
			System.out.println("red");
			break;
		case green:
			System.out.println("green");
			break;
		case blue:
			System.out.println("blue");
			break;
		default:
			System.out.println("break");
			break;
		}

		// name() 输出枚举对象的name
		System.out.println(myColor.name());// red
		// ordinal() 每一个枚举变量都对一个ordinal值 第一个变量从0开始
		System.out.println(Color.red.ordinal());// 0
		// valueOf() 传入String red 变成一个Color的对象
		Color.valueOf("red");
		// 返回所有对象的数组
		Color.values();

	}

}
