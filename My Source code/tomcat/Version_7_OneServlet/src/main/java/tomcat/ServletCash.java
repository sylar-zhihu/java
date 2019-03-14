package tomcat;
/*
 * 作者:
 * 日期:2019年3月14日:下午1:34:44
 * 程序作用:缓存servlet对象
**/

import java.util.HashMap;
import java.util.Map;

import sun.Servlet;

public class ServletCash {

    static HashMap<String, Servlet> servletMap = new HashMap<>();

    public static void putServlet(String servletUrl, Servlet servlet) {
        servletMap.put(servletUrl, servlet);
    }

    public static Servlet getServlet(String servletUrl) {
        return servletMap.get(servletUrl);
    }

}
