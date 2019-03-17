package anotation.classValue.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutoUser {
	@Value("tom")
	private String name;
	@Value("18")
	private Integer age;
	
	@Autowired //自动装配
	//问题:如果匹配多个类型一致的对象.将无法选择具体注入哪一个对象.
	@Qualifier("autoCar")//使用@Qualifier注解告诉spring容器自动装配哪个名称的对象
	private AutoCar car;
	
	public AutoCar getCar() {
		return car;
	}
	public void setCar(AutoCar car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
}
