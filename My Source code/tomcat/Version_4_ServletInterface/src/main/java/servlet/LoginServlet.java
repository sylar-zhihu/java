package servlet;

import servlet.javax.servlet.Servlet;

/*
 * 作者:
 * 日期:2019年3月13日:下午4:49:50
 * 程序作用:处理登录
**/
public class LoginServlet implements Servlet {
    
    // 处理业务的核心类
    @Override
    public void service() {
        System.out.println("正在处理");
    }

}
