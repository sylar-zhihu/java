package reflex_demo;

import java.lang.reflect.Method;

public class Fan_She_6_Methed_Example {
	// 在这个函数中调用Fan_She_6_Methed_Example_Help的main方法
	public static void main(String[] args) throws Exception {
		// 直接用静态方法调用
		Fan_She_6_Methed_Example_Help.main(new String[] {"111","222"});
		// 这个时候不知道要执行哪个类
		String startClassName=args[0];
		Method mainMethod=Class.forName(startClassName).getMethod("main", String[].class);
		// main是静态方法  要用new Object[]{} 包起来 两种方法都可以 
		// 如果传入的是一个String 数组会被当成多个参数拆分开来
		mainMethod.invoke(null, new Object[] {new String[] {"111","222"}});
		// 告诉编译器是一个Object对象就不会拆包
		mainMethod.invoke(null, (Object) new String[] {"111","222"});
	}

}

class Fan_She_6_Methed_Example_Help {
	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		}

	}

}