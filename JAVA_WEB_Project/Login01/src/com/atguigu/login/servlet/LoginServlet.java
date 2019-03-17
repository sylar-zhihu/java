package com.atguigu.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.login.beans.User;
import com.atguigu.login.dao.UserDao;
import com.atguigu.login.dao.UserDaoImpl;

/**
 * 处理登录请求的Servlet Servlet是sun公司制定的标准. Tomcat(web应用服务器、Servlet容器)实现了这些标准. HttpServlet:
 */
public class LoginServlet extends HttpServlet {

    // 常用的方法: doGet doPost service
    // doGet:处理客户端的get方式的请求
    // doPost: 处理客户端的post方式的请求
    // service: 根据具体的请求方式去调用对应的doGet、doPost 方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 登录功能的实现.
        System.out.println("登录请求过来了.......");

        // 获取到 用户输入的用户名和密码 ， 进行登录业务的处理.

        // HttpServletRequest: 请求对象。
        // Servlet容器会在请求到达后，创建出一个request对象，
        // 将Http请求相关的信息全部都封装到该对象中.

        req.setCharacterEncoding("utf-8");
        // 获取用户名
        String username = req.getParameter("username");
        // 获取密码
        String password = req.getParameter("password");
        System.out.println(username + " , " + password);

        // 通过响应对象 HttpServletResponse ，给客户端响应数据
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取Dao对象
        UserDao userDao = new UserDaoImpl();

        User user = userDao.getUserByUsernameAndPassword(username, password);

        if (user == null) {
            // 通过重定向的方式去往登录页面
            // 服务器会给浏览器发送一个302状态码以及一个新的地址，
            resp.sendRedirect("login.html");

        } else {
            // 登录成功
            out.println("<h1><font color='green'>Login Success! 登录成功<font><h1>");
        }

        // 不使用数据库的方法 验证用户名与密码是否正确.
        // if ("Admin".equalsIgnoreCase(username) && "123456".equals(password)) { // 登录成功
        // out.println("<h1><font color='green'>Login Success! 登录成功<font><h1>");
        // } else { // 登录失败
        // // PrintWriter out = resp.getWriter();
        // out.println("<h1><font color='red'>Login Fail! 登录失败</font></h1>");
        // }

    }

}
