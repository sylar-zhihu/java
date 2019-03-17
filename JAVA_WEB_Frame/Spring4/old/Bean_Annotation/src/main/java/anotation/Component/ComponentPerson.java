package anotation.Component;

import org.springframework.stereotype.Component;


/**
 * @Component  注解的作用:
 * 相当于在xml文件中:
 * <bean id="person" class="com.atguigu.spring.annotation.Component.ComponentPerson">
 * 注解默认的id值 就是类名首字母小写
 * 可以在注解中手动指定id值:@Component (value="id值"),
 * 可以简写为:@Component ("id值")
 *
 *  相同意义的注解,作用没有任何区别：
 * 	@Service("user") // service层
 *  @Controller("user") // web层
 * 	@Repository("user")// dao层
 */
@Component()
public class ComponentPerson {
	
	private String name ; 
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "ComponentPerson [name=" + name +  "]";
	} 
	
	
}
