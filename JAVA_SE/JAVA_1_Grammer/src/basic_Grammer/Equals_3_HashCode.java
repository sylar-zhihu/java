package basic_Grammer;

import java.util.Collection;
import java.util.HashSet;

public class Equals_3_HashCode {
	/*
	 * 加入Hash算法中，修改参与计算的变量 再remove的时候删除不掉元素
	 * 所以不能修改参与计算的变量
	 */
	public static void main(String[] args) {
		Collection collection =new HashSet();
		Equals_3_HashCode_Help code_Help=new Equals_3_HashCode_Help(3,4);
//		Equals_3_HashCode_Help code_Help2=new Equals_3_HashCode_Help(3,4);
		collection.add(code_Help);
		code_Help.x=55;
		collection.remove(code_Help);// 修改参与计算的变量
		System.out.println(collection.size());// 1 删除不掉
	}

}

class Equals_3_HashCode_Help {
	
	int x;
	int y;
	public Equals_3_HashCode_Help(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equals_3_HashCode_Help other = (Equals_3_HashCode_Help) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
