package basicUse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 作者:
 * 日期:2017年6月5日:下午1:35:58
 * 程序作用:读取资源文件
**/
public class Demo_6_读取WEB目录文件 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        read5();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 通过ServletContext对象获取文件的绝对磁盘路径 获取src目录下文件
     * 
     * @throws IOException
     */
    public void read5() throws IOException {
        // 获取对象
        String path = getServletContext().getRealPath("/WEB-INF/classes/db.properties");
        // System.out.println(path);
        // C:\apache-tomcat-6.0.14\webapps\day09\WEB-INF\classes\db.properties

        // 获取输入流
        InputStream in = new FileInputStream(path);
        print(in);
    }

    /**
     * 获取WebRoot目录目录下db.properties文件
     * 读取classes根目录下的配置文件
     * @throws IOException
     */
    public void read4Userful() throws IOException {
        // ServletContext读取文件
        InputStream in = getServletContext().getResourceAsStream("/db.properties");
        // 打印方式
        print(in);
    }

    /**
     * 获取包目录下db.properties文件
     * 
     * @throws IOException
     */
    public void read3() throws IOException {
        // ServletContext读取文件
        InputStream in = getServletContext()
                .getResourceAsStream("/WEB-INF/classes/cn/itcast/context/db.properties");
        // 打印方式
        print(in);
    }

    /**
     * 获取src目录下db.properties文件
     * 
     * @throws IOException
     */
    public void read2() throws IOException {
        // ServletContext读取文件
        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        // 打印方式
        print(in);
    }

    /**
     * 传统方式读取资源文件 交给服务器处理，相对的位置tomcat/bin
     * 根本找不到，因为发布到服务器，不会加入项目的根路径
     * @throws IOException
     */
    public void read1NotUse() throws IOException {
        // 获取输入流
        InputStream in = new FileInputStream("src/db.properties");
        print(in);
    }

    /**
     * 在控制台打印内容
     * 
     * @param in
     * @throws IOException
     */
    public void print(InputStream in) throws IOException {
        Properties pro = new Properties();
        // 加载
        pro.load(in);
        // 获取文件中的内容
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        String desc = pro.getProperty("desc");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("描述：" + desc);
    }

}
