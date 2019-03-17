package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.CollectionBean;

/**
 * 集合类型的属性注入
 * 
 * @author jt
 *
 */
public class Test_4_CollectionDi {

	@Test
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("di.xml");
		
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
		System.out.println(collectionBean);
	}
}
