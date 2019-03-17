package scoket_tcp.demo_3_Obj;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * 作者:
 * 日期:2016年11月25日:下午7:55:08
 * 程序作用:新建一个List<String>对象传输过去
**/
public class Client {

    public static void main(String[] args) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        try {
            // 新建连接
            Socket s = new Socket("127.0.0.1", 9876);

            // 读取类
            List<String> list = new ArrayList<>();
            list.add("aa");
            list.add("bb");

            // 输出类
            ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
            // 读取类
            ObjectInputStream reader = new ObjectInputStream(s.getInputStream());
            

            objectOutput.writeObject(list);
            System.out.println("把list传输到服务器");

            // 接受服务器的返回
            List<String> readObject  = (List<String>) reader.readObject();
            for (String str : readObject) {
                System.out.println(str);
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
