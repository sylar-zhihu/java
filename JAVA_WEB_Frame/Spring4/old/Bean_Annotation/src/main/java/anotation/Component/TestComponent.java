package anotation.Component;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestComponent {

    @Test
    // 加上了Component 可以直接得到对象 代替配置文件
    public void testComponent() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-annotation.xml");


        ComponentPerson person = ctx.getBean("componentPerson", ComponentPerson.class);
        // 但是没有注入任何属性值
        System.out.println(person);
    }

}
