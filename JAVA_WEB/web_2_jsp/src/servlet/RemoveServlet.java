package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 清除cookie
 * @author Administrator
 *
 */
public class RemoveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 717641936110777278L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取cookie
		// 创建Cookie的名称product
		Cookie cookie = new Cookie("product", "");
		// 设置有效时间
		cookie.setMaxAge(0);
		// 设置有效路径
		cookie.setPath("/");
		// 回写
		response.addCookie(cookie);
		// 重定向商品列表页面
		response.sendRedirect("/web2_jsp/cookie/productList.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
