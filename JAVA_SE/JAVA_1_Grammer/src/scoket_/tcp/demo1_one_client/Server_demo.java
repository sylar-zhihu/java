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
 * 程序作用:
**/
public class Server_demo {
    
    public static void main(String[] args) {
        try {
            // 开启服务器  监听9874 端口
            ServerSocket ss= new ServerSocket(9876);
            System.out.println("服务已经启动");
            // 等待客户端连接 返回一个socket 连接 是阻塞式的
            Socket serverSocket = ss.accept();
            System.out.println("有人连接");
            // 得到客户端数据的对象
            BufferedReader clientSentenceReader=new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            // 得到客户端的输入
            String clientSentence=clientSentenceReader.readLine();
            System.out.println(clientSentence);
            // 回给客户端信息
            PrintWriter toClientWriter =new PrintWriter(serverSocket.getOutputStream(),true);
            // 写信息
            toClientWriter.println("我是服务器");
            
            System.out.println("服务器程序结束");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
