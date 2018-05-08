package 工厂模式;

/*
 * 作者:Lijianbo
 * 日期:2016年5月3日:下午1:50:18
 * 程序作用:
 * 这里是一个工厂
 * 定义一个车的接口：有run方法
 * Audi,Auto都实现了这个接口
 * 在定义一个工厂类：产生这两个类型的对象
**/


public class Factory_1 {
	/*
	 * 根据传入的name返回车
	 */
	public Car createCar(String name) {
		if (name.equals("Audi")) {
			return new Audi();
		} else {
			return new Auto();
		}
	}

	public static void main(String[] args) {
		Factory_1 factory = new Factory_1();
		Car car = factory.createCar("Audi");
		car.run();
	}
}

interface Car {
	/*
	 * 定义一个抽象的车
	 */
	public void run();
}

class Audi implements Car {
	@Override
	public void run() {
		System.out.println("Audi Run");
	}
}

class Auto implements Car {
	@Override
	public void run() {
		System.out.println("Auto Run");
	}
}