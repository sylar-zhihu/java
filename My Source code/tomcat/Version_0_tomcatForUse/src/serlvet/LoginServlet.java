package serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet {

    // 常用的方法: doGet doPost service
    // doGet:处理客户端的get方式的请求
    // doPost: 处理客户端的post方式的请求
    // service: 根据具体的请求方式去调用对应的doGet、doPost 方法


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
   
    }

    
    

}
