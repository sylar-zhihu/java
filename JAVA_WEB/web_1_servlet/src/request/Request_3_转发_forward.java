package request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向
 * 
 * @author Administrator
 *
 */

public class Request_3_转发_forward extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request域设置内容
        request.setAttribute("name", "凤姐");

        // 转发（路径服务器的url绝对路径） 固定写法 
        // 访问的是http://localhost:8080/web_1_servlet/forward
        request.getRequestDispatcher("/forwardHelp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
