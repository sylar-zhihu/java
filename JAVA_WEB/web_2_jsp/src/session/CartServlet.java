package session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * 作者:Lijianbo
 * 日期:2016年7月12日:下午2:31:59
 * 程序作用:购物车后台
**/

public class CartServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4944571720622706932L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * 1.购物车	Map<String,Integer> cart	把购物车存入session中
		 * 2.先获取购物车，判断是否是第一次访问
		 * 第一次访问：创建购物车，把商品的名称和数量加入到购物车，存入session中
		 * 不是第一次访问,判断是否包含该商品，通过名称
		 * 如果包含，数量+1,存入session中, 如果不包含，存入购物车，存入session中
		 * 3.继续购物或者结算
		 */
		// 获取参数
		String id = request.getParameter("id");
		// 购物车存入商品的名称和数量
		String [] names = {"手电筒","冰箱","电视","洗衣机","电脑"};
		// 把id翻译名称
		int idx = Integer.parseInt(id);
		// 商品的名称
		String name = names[idx - 1];
		// 从session中获取购物车，先获取seesion
		HttpSession session = request.getSession();
		// 从session中获取购物车
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		// 通过cart进行判断，是否是第一次访问
		if(cart == null){
			// 创建购物车
			cart = new HashMap<String, Integer>();
			// 第一次访问
			cart.put(name, 1);
			// 存入到session中
			session.setAttribute("cart", cart);
		}else{
			// 不是第一次访问，判断是否包含该商品
			if(cart.containsKey(name)){
				// 包含，取出数量，+1，存入购物车，存入seesion中
				// 取出
				Integer count = cart.get(name);
				count++;
				// 购物车存入商品
				cart.put(name, count);
				// 存入的是购物车
				session.setAttribute("cart", cart);
			}else{
				// 不包含
				cart.put(name, 1);
				// 存入到seesion中
				session.setAttribute("cart", cart);
			}
		}
		// 继续购物或者结算
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h3><a href='/web2_jsp/session/cartList.jsp'>继续购物</a> | <a href='/web2_jsp/session/pay.jsp'>去结算</a></h3>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}






