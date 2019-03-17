package advisorBefore;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置增强,需要实现接口
 *
 */
// 实现接口
public class MyBeforeAdvice implements MethodBeforeAdvice{

	/**
	 * method:执行的方法
	 * args:参数
	 * target:目标对象
	 */
        @Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("前置增强...");
	}
}
