package basicUse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承HttpServlet 重写方法 返回页面 配置servlet启动时加载
 * 
 * @author Administrator
 *
 */
public class Demo_01_HttpServlet extends HttpServlet {

    private static final long serialVersionUID = -5940330698968831288L;

    // 重写方法 就能返回也面内容 客户端用get方式访问的时候 调用这个方法
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet...");
        // 向页面输出内容
        response.getWriter().write("hello demo5...");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
