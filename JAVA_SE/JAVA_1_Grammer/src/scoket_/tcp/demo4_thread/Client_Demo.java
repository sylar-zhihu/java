package scoket_.tcp.demo4_thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 作者:
 * 日期:2016年11月25日:下午7:55:08
 * 程序作用:自发送一次信息
**/
public class Client_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // 新建连接
            Socket socket = new Socket("127.0.0.1", 9876);
            System.out.println("客户端启动");
            // 从控制台 输入
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            String sentence ;
            // 向服务器 发送信息 true 表示实时刷新
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            // 接受服务器请求
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (true) {
                // 从控制台输入
                sentence= inFromUser.readLine();
                // 发送到服务器
                pw.println(sentence);
                // 接受服务器的话
                sentence = bufferedReader.readLine();
                if (sentence.equals("bye")) {
                    break;
                }
                System.out.println(sentence);
            }

            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
