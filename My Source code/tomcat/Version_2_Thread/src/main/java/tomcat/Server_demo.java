package tomcat;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;


/*
 * 作者:
 * 日期:2016年11月25日:下午7:50:29
 * 程序作用:
**/
public class Server_demo {

    static Integer port;

    public static void main(String[] args) throws IOException {
        // 读取配置
        getPorperties() ;
        // 程序入口
        start();

    }

    public static void getPorperties() throws IOException {
        Properties properties = new Properties();
        properties.load(Server_demo.class.getClassLoader().getResourceAsStream("tomcat.properties"));
        port = Integer.valueOf(properties.getProperty("port"));

    }

    private static void start() {
        try {
            // 开启服务器 监听8080 端口
            ServerSocket ss = new ServerSocket(port);
            System.out.println("服务已经启动");
            // 等待客户端连接 返回一个socket 连接 是阻塞式的
            while (true) {
                // 等待客户端连接 返回一个socket 连接 是阻塞式的
                Socket socket = ss.accept();
                System.out.println("有人连接");

                HanderRequestThread handerRequestThread = new HanderRequestThread(socket);
                // 启动线程
                Thread thread = new Thread(handerRequestThread);
                thread.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
