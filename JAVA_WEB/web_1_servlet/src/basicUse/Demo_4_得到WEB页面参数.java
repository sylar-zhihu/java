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
public class Demo_4_得到WEB页面参数 extends HttpServlet {

    private static final long serialVersionUID = -5312566926620130368L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter = request.getParameter("userName");
		System.out.println(parameter);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
