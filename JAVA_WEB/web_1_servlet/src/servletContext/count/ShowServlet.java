package servletContext.count;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 作者:
 * 日期:2017年6月5日:下午1:35:58
 * 程序作用:显示网站的访问次数
**/

public class ShowServlet extends HttpServlet {

    /**
     * 获取网站的访问次数，输出到客户端
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer count = (Integer) getServletContext().getAttribute("count");
        // 向页面输出
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h3>该网站一共被访问了" + count + "次</h3>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
