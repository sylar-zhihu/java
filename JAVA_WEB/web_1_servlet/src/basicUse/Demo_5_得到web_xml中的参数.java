package basicUse;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 作者:
 * 日期:2017年6月5日:下午1:35:58
 * 程序作用:从web.xml中得到这个类的ServletConfig数据
**/
public class Demo_5_得到web_xml中的参数 extends HttpServlet {

    private static final long serialVersionUID = -5312566926620130368L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 测试ServletConfig对象的api
		// 先获取ServletConfig对象
		ServletConfig config = getServletConfig();
		// 获取配置文件中serlvet的名称
		System.out.println("servlet的名称："+config.getServletName());
		// 获取初始化的参数
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		System.out.println(username+" ： "+password);
		
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+" : "+value);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
