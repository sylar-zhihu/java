package basic_Grammer;

public class Equals_1_ {
	/*
	 * 每一个对象都有一个equals方法
	 * 默认的和==一样是比较两个对象的内存地址
	 */

	public static void main(String[] args) {
		Object a =new Object();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// 从这个equals里面可以看到和==是一样的
		return super.equals(obj);
	}
}
