package scoket_.tcp.demo1_one_client;

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
 * 程序作用:这个是原始形式比较麻烦
**/
public class Server_demo_old {
    
    public static void main(String[] args) {
        try {
            // 开启服务器  监听9874 端口
            ServerSocket ss= new ServerSocket(9876);
            System.out.println("服务已经启动");
            // 等待客户端连接 返回一个socket 连接 是阻塞式的
            Socket s = ss.accept();
            System.out.println("有人连接");
            // 读取客户端的信息
            InputStreamReader reader=new InputStreamReader(s.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(reader);
            System.out.println(bufferedReader.readLine());
            //  true 表示实时刷新
            PrintWriter pw =new PrintWriter(s.getOutputStream(),true);
            pw.println("我是服务器");
            
            System.out.println("服务器程序结束");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
