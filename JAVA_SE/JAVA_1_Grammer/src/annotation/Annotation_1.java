package annotation;

import javax.jws.soap.SOAPBinding;

/*
 * Author:Lijianbo
 * date:2016年4月25日
 * time:下午5:29:10
**/

// 添加注解属性
@Annotation_2(color="red",value="aa",arrayAttr={1,2,3})
public class Annotation_1 {
	/*
	 * @Annotation_2使用这个注解来修饰Annotation_1
	 * 注解相当于python的装饰器
	 */
	int age;

	/* 
	 * 表示覆盖父类方法 如果传入的变量不是Object类型会报错
	 * 不是Object类型相当于新写了一个方法
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Annotation_1 other = (Annotation_1) obj;
		if (age != other.age)
			return false;
		return true;
	}

	// 这个注解表示方法过时
	@Deprecated
	private void sayHello() {
		System.out.println("Hello");

	}

	public static void main(String[] args) {
		/*
		 * 检测类上面是否有注解@Annotation_2
		 */
		if (Annotation_1.class.isAnnotationPresent(Annotation_2.class)) {
			// 得到注解的类的对象
			Annotation_2 annotation_2 = Annotation_1.class.getAnnotation(Annotation_2.class);
			// 使用注解属性
			System.out.println(annotation_2.color());

		}
	}

}
