package basic_Grammer;

public class Enum_Enhance {
	/*
	 * 为枚举加入构造方法
	 * 感觉不常用
	 * 但是抽象的构造方法常用
	 * 给每一个枚举对象定义一些特有的方法
	 * 如：
	 * 下一个灯是什么颜色
	 * 每一个等亮的时间
	 */

	// 定义枚举 灯
	public enum Lamp {
		// 调用自己的构造方法 同时实现一个必须实现的方法
		RED (30){

			@Override
			public Lamp nextLamp() {
				return GREEN;
			}

		},
		GREEN(45) {

			@Override
			public Lamp nextLamp() {
				return YELLOW;
			}
		},
		YELLOW(5) {

			@Override
			public Lamp nextLamp() {
				return RED;
			}
		};
		// 定义构造方法
		private Lamp() {
			System.out.println("first");
		}

		private Lamp(int time) {
			// 每一个灯亮的时间
			System.out.println("second");
			this.time=time;
		}
		private int time;

		// 抽象类 由不同的灯来实现下一个灯是什么灯 抽象方法必须实现
		public abstract Lamp nextLamp();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
