package anotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// 属性上 set方法上都可以使用
public class ValuePerson {

	@Value("sylar")
	private String name ;

    private String name2 ;

    @Value("18")// int类型
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName2() {
        return name2;
    }

    @Value("sylar2")
    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
	public String toString() {
		return "ComponentPerson [name1=" + name + " name1= "+name2+" age= "+age+"]";

	} 
	
	
}
