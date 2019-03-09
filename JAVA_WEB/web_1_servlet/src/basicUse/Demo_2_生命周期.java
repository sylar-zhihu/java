package basicUse;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 生命周期
 * @author Administrator
 *
 */
public class Demo_2_生命周期 implements Servlet {
	
	/**
	 * Servlet实例被创建后，调用init方法进行初始化
	 * Servlet什么时候被创建呢？
	 * 不是服务器一启动时，实例被创建，第一次访问的时候，实例才被创建。
	 * init方法调用几次呢？
	 * 只被调用一次。
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init...");
	}
	
	/**
	 * service调用几次呢？
	 * 有一次请求doget 或dopost，调用一次service方法
	 */
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("service...");
	}
	
	/**
	 * Servlet实例什么时候被销毁呢？
	 * 	* 服务器关闭，手动移除。
	 * 	destroy调用几次呢？
	 * 	* 一次	
	 */
	public void destroy() {
		System.out.println("destroy...");
	}
	
	
	
	
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return null;
	}
}
