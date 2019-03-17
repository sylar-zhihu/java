package scoket_tcp.demo_0_oneSentence;

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
 * 程序作用:自发送一次信息 最简洁的写法
**/
public class Client_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            System.out.println("客户端已经启动");
            // 新建连接
            Socket socket = new Socket("127.0.0.1", 9876);
            System.out.println("请输入一句话 发送到服务器端");
            // 从控制台 输入
            BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in));
            String sentence = inFromUser.readLine();
            
            // 得到向服务器写数据的对象 发送信息 true 表示实时刷新
            PrintWriter outToServerWriter =new PrintWriter(socket.getOutputStream(),true);
            // 发送一句话
            outToServerWriter.println(sentence);

            
            // 接受服务器请求对象
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String sentenceFromServer;
            sentenceFromServer = inFromServer.readLine();
            System.out.println(sentenceFromServer);
            
            // 
            socket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }

    }

}
