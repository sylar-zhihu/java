package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 校验验证码
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5683537422566655209L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决post请求中文乱码的问题
		request.setCharacterEncoding("UTF-8");
		
		//HttpSession session = request.getSession();
		// 获取session中验证码
		//String code1 = (String) session.getAttribute("code");
		
		String code1 = (String) request.getSession().getAttribute("code");
		
		System.out.println(code1);
		
		// 获取表单中的验证码
		String code2 = request.getParameter("code");
		// 是否相同
		if(code2 != null && code1.equals(code2)){
			response.getWriter().write("success");
		}else{
			// 如果不相同，返回错误的信息
			// 转发
			request.setAttribute("msg", "验证码输入错误");
			request.getRequestDispatcher("/session/login.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
