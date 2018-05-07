package scoket_.tcp.demo4_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.out.println("服务已经启动");
            // 循环等待
            while (true) {
                // 等待客户端连接 返回一个socket 连接 是阻塞式的
                Socket socket = ss.accept();
                System.out.println("有人连接");

                ServerThread serverThread = new ServerThread(socket);
                // 启动线程
                Thread thread = new Thread(serverThread);
                thread.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
