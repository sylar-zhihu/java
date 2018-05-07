package basic_Grammer;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Author:Lijianbo
 * date:2016年4月25日
 * time:下午3:42:54
**/
public class JAVABean_2 {
	/*	
	 * 给出字符串x,得到对象的x属性
	 * 用反射的办法得到类的属性
	 * 不用像一般的反射那样麻烦
	 * java有一套简单的api
	 */

	public static void main(String[] args) throws Exception {
		// 创建一个对象
		JAVABean_1 bean_1 = new JAVABean_1(3, 5);
		// 给定一个字符串,让你得到和这个字符串同名的对象的属性
		String attributeName = "x";
		// 属性描述类 第一个参数属性的名字，第二个类的class字节码
		PropertyDescriptor descriptor = new PropertyDescriptor(attributeName, bean_1.getClass());
		// 通过属性描述符调用set get 方法
		// 得到get方法的字节码
		Method methodGetX = descriptor.getReadMethod();
		// 通过方法的字节码调用方法
		Object retValue = methodGetX.invoke(bean_1);
		System.out.println(retValue);// 3
		// set方法
		Method methodSetX = descriptor.getWriteMethod();
		methodSetX.invoke(bean_1, 7);
		System.out.println(bean_1.getX());// 7
		/*
		 * 如果没有属性描述类 这个方法 使用最原始的方法
		 * 通过Introspector 得到某一个类的beaninfo 把这个类当成javabean来处理
		 */
		BeanInfo beanInfo = Introspector.getBeanInfo(bean_1.getClass());
		// 得到这个bean的所有属性
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		// 遍历属性得到需要的属性
		for (PropertyDescriptor pd : descriptors) {
			// 如果和给定的属性名相等
			if (pd.getName().equals(attributeName)) {
				Method methodSetX2 = pd.getWriteMethod();
				methodSetX2.invoke(bean_1, 7);
				System.out.println(bean_1.getX());// 7
				break;
			}
		}
	}

}
