package sesstion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 继承HttpServlet 重写方法 返回页面 配置servlet启动时加载
 * 
 * @author Administrator
 *
 */
public class Sesstion_1_API extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Sesstion_1_API 被访问");
        // 得到sesstion
        HttpSession session = request.getSession();
        // 放入属性
        session.setAttribute("key", "value");
        // 也可以放入对象
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        session.setAttribute("map", map);
        // 得到属性
        session.getAttribute("key");
        request.getRequestDispatcher("/Sesstion_1_Help.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
