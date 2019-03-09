package request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取客户机的内容
 * 
 * @author Administrator
 *
 */
public class Request_1_不常用参数 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取IP
        String ip = request.getRemoteAddr();
        // 获取请求方式
        String method = request.getMethod();
        // 获取虚拟路径
        String path = request.getContextPath();
        System.out.println("IP地址：" + ip);
        System.out.println("请求方式：" + method);
        System.out.println("虚拟路径名称：" + path);

        // 获取请求头记住来源(防盗链)
        String referer = request.getHeader("referer");
        // 判断浏览器（文件下载）
        String agent = request.getHeader("user-agent");
        // 得到所有的参数名
        Enumeration<String> parameterNames = request.getParameterNames();
        

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
