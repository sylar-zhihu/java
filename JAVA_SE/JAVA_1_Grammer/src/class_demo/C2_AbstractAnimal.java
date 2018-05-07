package class_demo;

/*
 * 作者:Lijianbo
 * 日期:2016年5月3日:上午11:48:15
 * 程序作用:抽象类的使用
**/

abstract class C2_AbstractAnimal {
	/*
	 * 含有抽象方法的类必须是抽象类 抽象类不能new对象
	 * 抽象方法没有实现，由子类去实现。
	 * 但是可以有Static方法
	 */

	abstract void bark();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Dog extends C2_AbstractAnimal {
	@Override
	void bark() {// 必须实现父类的抽象方法
		// TODO Auto-generated method stub
		System.out.println("狗叫");
	}
}
