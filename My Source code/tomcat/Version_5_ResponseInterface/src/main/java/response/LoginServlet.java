package response;

import response.sun.Servlet;
import response.sun.ServletResponse;



/*
 * 作者:
 * 日期:2019年3月13日:下午4:49:50
 * 程序作用:处理登录
**/
public class LoginServlet implements Servlet {
    
    // 处理业务的核心类
    @Override
    public void service(ServletResponse response) {
        System.out.println("service");
        response.getWriter().print("<html>");
        response.getWriter().print("<body>");
        response.getWriter().print("<h1>正在验证</h1>");
        response.getWriter().print("<body>");
        response.getWriter().print("<h1>正在验证</h1>");
        response.getWriter().print("</body>");
        response.getWriter().print("</html>");
        response.getWriter().flush();
    }

}
