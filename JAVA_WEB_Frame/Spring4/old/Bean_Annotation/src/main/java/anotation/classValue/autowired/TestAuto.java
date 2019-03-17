package anotation.classValue.autowired;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAuto {

    /**
     *  @Autowired 完成bean属性的自动装配
     *  工作机制:  首先会使用byType的方式进行自动装配，如果能唯一匹配，则装配成功，
     *           如果匹配到多个兼容类型的bean, 还会尝试使用byName的方式进行唯一确定.
     *           如果能唯一确定，则装配成功，如果不能唯一确定，则装配失败，抛出异常.
     *
     *  默认情况下， 使用@Autowired标注的属性必须被装配，如果装配不了，也会抛出异常.
     *  可以使用required=false来设置不是必须要被装配.
     *
     *  如果匹配到多个兼容类型的bean，可以使用@Qualifier来进一步指定要装配的bean的id值 。
     *
     *  @Autowired @Qualifier 注解即可在成员变量上，也可以加在对应的set方法上..
     *
     */

    @Test
    public void testAutoWire() {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-annotation.xml");

        // 使用value给perpom 注入属性
        AutoUser autoUser = ctx.getBean("autoUser", AutoUser.class);
        System.out.println(autoUser);
    }

}
