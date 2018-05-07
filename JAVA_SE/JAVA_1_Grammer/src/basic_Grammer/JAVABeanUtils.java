package basic_Grammer;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/*
 * Author:Lijianbo
 * date:2016年4月25日
 * time:下午4:36:17
**/
public class JAVABeanUtils {
	/*
	 * 好处一：
	 * 参数和返回值永远是String，不管传入，和返回的是什么类型。
	 * 这样更通用。
	 */

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// 新建对象
		JAVABean_1 bean_1 = new JAVABean_1(3, 5);
		// get直接得到bean_1的x的值 
		System.out.println(BeanUtils.getProperty(bean_1, "x"));
		// 得到的都是string类型 不管原来是啥类型。
		System.out.println(BeanUtils.getProperty(bean_1, "x").getClass().getName());
		// set 就算是int类型 传入的时候还是用string 这样更通用
		BeanUtils.setProperty(bean_1, "x", "9");
		// date类型 可以跨越多级设置
		BeanUtils.setProperty(bean_1, "birthday.time", "111");
		System.out.println(BeanUtils.getProperty(bean_1, "birthday"));
		// 如果不希望使用String传入和返回 PropertyUtils
		// 写"9"String会报异常
		PropertyUtils.setProperty(bean_1, "x", 9);
		// Integer
		System.out.println(PropertyUtils.getProperty(bean_1, "x").getClass().getName());

	}

}
