package 工厂模式;

/*
 * Author:Lijianbo
 * date:2016年5月3日
 * time:上午11:39:13
**/
public class Factory_Single {
	/*
	 * 单例同时工厂
	 */
	private static Car carAudi = new Audi();
	private static Car carAuto = new Auto();

	public Car createCar(String name) {
		if (name.equals("Audi")) {
			return carAudi;
		} else {
			return carAuto;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
