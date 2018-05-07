package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Author:Lijianbo
 * date:2016年4月25日
 * time:下午6:07:42
**/

// 保存到RUNTIME阶段
@Retention(RetentionPolicy.RUNTIME)
// 能被这个注解，注解的对象 参数是一个数组
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Annotation_2 {
	/*
	 * 这里自定义一个注解
	 */

	/*
	 * 属性
	 * 有一个color属性 值为字符串
	 * 默认就是public,abstract
	 */
	public String color() default "blue";

	// 如果只有value属性value=可以省略
	public String value();

	// 定义一个数组类型
	int[] arrayAttr();
	// 枚举类型
	public enum Lamp {
		RED,GREEN,YELLOW
	}
	Lamp lamp() default Lamp.GREEN ;
}
