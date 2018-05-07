package scoket_.tcp.demo4_thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 作者:
 * 日期:2017年4月22日:上午9:45:12
 * 程序作用:
**/
public class ServerThread implements Runnable {

    Socket socket = null;

    public ServerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 得到客户端数据的对象
            BufferedReader clientSentenceReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 得到客户端的输入
            String clientSentence=clientSentenceReader.readLine();
            System.out.println(clientSentence);
            
            //  回给客户端信息 对象 true 表示实时刷新
            PrintWriter outToClientWriter =new PrintWriter(socket.getOutputStream(),true);
            outToClientWriter.println(clientSentence);
            System.out.println("信息已经发出");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
    }

}
