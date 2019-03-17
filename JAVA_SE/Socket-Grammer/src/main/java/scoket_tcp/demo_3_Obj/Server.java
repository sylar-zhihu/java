package scoket_tcp.demo_3_Obj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/*
 * 作者:
 * 日期:2016年11月25日:下午7:50:29
 * 程序作用:传输对象，对象需要实现序列化接口
**/
public class Server implements Serializable{

    public static void main(String[] args) {
        try {
            // 开启服务器 监听9874 端口
            ServerSocket ss = new ServerSocket(9876);
            // 等待客户端连接 返回一个socket 连接 是阻塞式的
            Socket s = ss.accept();
            System.out.println("服务器已经启动");
            
            System.out.println("有人连接成功");
            // 读取类
            ObjectInputStream reader = new ObjectInputStream(s.getInputStream());
            // 输出类
            ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
            
            try {
                List<String> readObject = (List<String>)reader.readObject();
                for (String string : readObject) {
                    System.out.println(string);
                }
                objectOutput.writeObject(readObject);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           

          

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
