package servletContext;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 作者:
 * 日期:2017年6月5日:下午1:35:58
 * 程序作用:从web.xml中得到全局对象
**/
public class Context全局共享对象 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 先获取ServletContext对象
        ServletContext context = getServletContext();
        // 获取初始化参数
        String encoding = context.getInitParameter("encoding");
        System.out.println("编码：" + encoding);

        Enumeration<String> e = context.getInitParameterNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            // 通过name获取值
            String value = context.getInitParameter(name);
            System.out.println(name + " : " + value);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
