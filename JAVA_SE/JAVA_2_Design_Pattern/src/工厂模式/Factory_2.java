package 工厂模式;

/*
 * 作者:Lijianbo
 * 日期:2016年5月3日:下午1:50:18
 * 程序作用:
 * 和Factory_1不同的实现,这种直接把车名方法方法名上
**/
public class Factory_2 {
	/*
	 * 根据传入的name返回车
	 */
	public Car createAudi() {
		return new Audi();
	}

	public Car createAuto() {
		return new Auto();
	}

	public static void main(String[] args) {
		Factory_2 factory = new Factory_2();
		Car car = factory.createAudi();
		car.run();
	}
}
