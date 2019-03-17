package anotation.value;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestValue {

    @Test
    // 测试使用value注入属性值
    public void testValue() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-annotation.xml");

        // 使用value给perpom 注入属性
        ValuePerson person = ctx.getBean("valuePerson", ValuePerson.class);
        System.out.println(person);
    }

}
