package response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 作者:
 * 日期:2017年6月6日:上午10:18:30
 * 程序作用:登录验证
**/

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String projectName="web_2_response_request";

        /**
         * 先获取用户输入的内容（request对象） 判断姓名和密码是否都是admin，如果有一个不是，重定向到登陆页面，如果都是，就登陆成功。
         */
        // 获取用户输入的内容
        String username = request.getParameter("username"); // 程序入口
        // 获取密码
        String password = request.getParameter("password");
        // 判断
        if ("admin".equals(username) && "admin".equals(password)) {
            // 登陆成功
            // 重定向到登陆页面
            response.sendRedirect("/"+projectName+"/response/refresh.html");// 项目名为根路径
        } else {
            // 重定向到登陆页面
            // 设置302的状态码
            // response.setStatus(302);
            // 设置地址
            // response.setHeader("location", "/day10/response/login.html");

            // 重定向 这种更简单
            response.sendRedirect("/"+projectName+"/response/login.html");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
