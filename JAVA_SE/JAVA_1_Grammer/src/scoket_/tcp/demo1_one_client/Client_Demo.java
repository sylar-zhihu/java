package scoket_.tcp.demo1_one_client;

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
            System.out.println("客户端已经启动");
            // 新建连接
            Socket clientSocket = new Socket("127.0.0.1", 9876);
            // 从控制台 输入
            BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in));
            String sentence = inFromUser.readLine();
            
            // 得到向服务器写数据的对象
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            // 发送 必须以\n结尾才能发出去
            outToServer.writeBytes(sentence + '\n');

            
            // 接受服务器请求对象
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String sentenceFromServer;
            sentenceFromServer = inFromServer.readLine();
            System.out.println(sentenceFromServer);
            
            // 
            clientSocket.close();

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
