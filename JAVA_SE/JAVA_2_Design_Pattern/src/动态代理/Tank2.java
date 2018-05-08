package 动态代理;

import java.util.Random;
/*
 * 作者:
 * 日期:2018年3月28日:下午2:07:48
 * 程序作用:实现了两个接口，两个接口运行时间都需要记录
**/

public class Tank2 implements Moveable,Stopable {

	@Override
	public void move() {
		
		System.out.println("Tank Moving...");
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
