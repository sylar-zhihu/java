package basic_Grammer;

/*
 * Author:Lijianbo
 * date:2016年4月20日
 * time:下午3:57:36
**/
public class Try_2_loop {
	/*
	 * 在循环中的异常
	 */

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			try {
				
				System.out.println(i);
				System.out.println(1 / 0);
				// 出了异常会循环执行 但是后面的代码不会执行进入catch 然后再次进入循环
				System.out.println("a");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

}
