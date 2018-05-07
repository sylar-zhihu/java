package basic_Grammer;

import java.util.ArrayList;

public class Fan_Xing_1 {

	public static void main(String[] args) {
		// 在<>中指定数组的数据类型
		ArrayList<Bird> a1=new ArrayList<Bird>();
		// 在类中使用泛型
		Gen<String> gen1=new Gen<String>("aaa");
		gen1.show();// java.lang.String
		Gen<Integer> gen2=new Gen<Integer>(5);
		gen2.show();// java.lang.Integer
		//自己定义的类型
		Gen<Bird> gen3=new Gen<Bird>(new Bird());
		gen3.show();// collection_grammer.Bird
	}

}

class Bird{
	public void show() {
		System.out.println("i am bird");
	}
	
}
//  类的泛型 传入的是什么类型就定义什么类型
class Gen<T>
 {
	public T t;
	// 构造函数
	public Gen(T a) {
		// TODO Auto-generated constructor stub
		this.t=a;
	}

	public void show() {
		System.out.println(t.getClass().getName());
	}
}
