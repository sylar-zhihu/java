package response;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 作者:
 * 日期:2017年6月6日:上午10:18:30
 * 程序作用:输出中文的乱码的问题
**/
public class D_1_设置返回类型和编码方式 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
         // 名字 value
        Cookie cookie=new Cookie("name", "value");
        // 存在时间
        cookie.setMaxAge(3600);
        // 返回加入cookie
        response.addCookie(cookie);
        
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
