package scoket_.tcp.demo3_Obj.old;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

/*
 * 作者:
 * 日期:2016年11月25日:下午7:55:08
 * 程序作用:多次发送信息。冲控制台输入信息.随时能够发送。
**/
public class Client_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // 新建连接
            Socket s = new Socket("127.0.0.1", 9876);
            Scanner scanner = new Scanner(System.in);
            String str = null;

            // 读取类
            InputStreamReader reader = new InputStreamReader(s.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            // 输出类
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            while (true) {
                System.out.println("请输入一句话");
                // 从控制台得到信息
                str = scanner.next();
                System.out.println("输入的话为"+str);
                // 输出给服务器
                pw.println(str);
                if (str.equals("bye")){
                    break;
                }
                // 接受服务器的返回
                System.out.println(bufferedReader.readLine());
            }
            s.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
