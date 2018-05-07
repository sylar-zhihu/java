package basic_Grammer;

import java.util.Date;

/*
 * Author:Lijianbo
 * date:2016年4月25日
 * time:下午3:08:25
**/
public class JAVABean_1 {
	/*
	 * 这里定义了一个类
	 * 同时对每个属性定义了get,set方法
	 */
	private int x;
	private int y;
	private Date birthday=new Date();
	
	public JAVABean_1(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	
	
	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
