package response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 转发
 * 
 * @author Administrator
 *
 */
public class D_2_SendRedirect extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request域设置内容
        request.setAttribute("name", "凤姐");

        // 完成重定向的工作 /+服务器项目名+/服务响应的url 
        // 前面会自动加上ip地址 实际上访问的是 http://localhost:8080/web_1_servlet/sendRedirectHelp
         response.sendRedirect("/web_1_servlet/sendRedirectHelp");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
