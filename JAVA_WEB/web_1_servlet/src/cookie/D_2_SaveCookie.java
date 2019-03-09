package cookie;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 作者:
 * 日期:2017年6月6日:上午10:18:30
 * 程序作用:输出中文的乱码的问题
**/
public class D_2_SaveCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 设置response缓冲区的编码
        //response.setCharacterEncoding("UTF-8");
        // 设置浏览器打开文件所采用的编码
        //response.setHeader("Content-Type", "text/html;charset=UTF-8");
        
        // 简写的形式（等于上面两句）
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("哈罗卧得");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
