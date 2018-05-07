package scoket_.tcp.demo2_more_senten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

/*
 * 作者:
 * 日期:2016年11月25日:下午7:50:29
 * 程序作用:
**/
public class Server_demo {

    public static void main(String[] args) {
        try {
            // 开启服务器 监听9874 端口
            ServerSocket ss = new ServerSocket(9876);
            // 等待客户端连接 返回一个socket 连接 是阻塞式的
            System.out.println("服务器已经启动");
            Socket s = ss.accept();
            Scanner scanner = new Scanner(System.in);
            String str = null;
            System.out.println("有人连接成功");
            // 读取类
            InputStreamReader reader = new InputStreamReader(s.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            // 输出类
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

            while (true) {
                System.out.println("aa");
                // 读取客户端的信息
                str = bufferedReader.readLine();
                if (str.equals("bye")) {
                    break;
                }
                System.out.println(str);
                // 从控制台接受一句话
                str = scanner.next();
                // 返回给客户端
                pw.println(str);

            }
            s.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
