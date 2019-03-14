package servlet;

import servlet.sun.Servlet;
import servlet.sun.ServletRequest;
import servlet.sun.ServletResponse;




/*
 * 作者:
 * 日期:2019年3月13日:下午4:49:50
 * 程序作用:处理登录
**/
public class LoginServlet implements Servlet {
    
    // 处理业务的核心类

    @Override
    public void service(ServletRequest request, ServletResponse response) {
        // TODO Auto-generated method stub
        String username = request.getParaValue("username");
        String password = request.getParaValue("password");
        System.out.println(username);
        System.out.println(password);
        
    }

}
