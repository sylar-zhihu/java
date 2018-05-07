package basic_Grammer;

/*
 * Author:Lijianbo
 * date:2016年4月20日
 * time:下午3:57:36
**/
public class Try_3_deep {
	/*
	 * 如果是调用方法里面有异常
	 */

	public static void main(String[] args) {
		Try_3_deep deep = new Try_3_deep();
		/*
		 * 这里的try在loop的里面
		 * 循环会继续执行
		 */
//		deep.tryInloop();
		/*
		 * 这里的try在loop的外面
		 * 循环不会继续执行
		 */
		deep.tryOutLoop();

	}

	private void tryOutLoop() {
		/*
		 * 这里的try在loop的外面
		 * 循环会继续执行
		 */
		Try_3_deep deep = new Try_3_deep();
		try {
			for (int i = 0; i < 20; i++) {
				deep.fun();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void tryInloop() {
		/*
		 * 这里的try在loop的里面
		 * 循环会继续执行
		 */
		Try_3_deep deep = new Try_3_deep();
		for (int i = 0; i < 20; i++) {
			try {
				System.out.println(i);
				deep.fun();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void fun() {
		// TODO Auto-generated method stub
		System.out.println(1 / 0);

	}

}
