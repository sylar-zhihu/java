package demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spring3.demo4.AccountService;
/**
 * 声明式事务使用:基于切注解的
 * @author 姜涛
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class Test_4_Annotation {

	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 100d);
	}
}
