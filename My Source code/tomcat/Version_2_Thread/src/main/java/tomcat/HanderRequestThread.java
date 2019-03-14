package tomcat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 作者:
 * 日期:2019年3月13日:下午12:45:11
 * 程序作用:处理客户端请求
**/
public class HanderRequestThread implements Runnable {

    Socket socket = null;

    public HanderRequestThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 得到客户端数据的对象
            BufferedReader clientSentenceReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientSentence = null;
            //  在第一行中 得到第一行
            String requestLine = clientSentenceReader.readLine();
            // 获取请求的uri
            String uri = requestLine.split(" ")[1];
            while ((clientSentence = clientSentenceReader.readLine()) != null) {
                System.out.println(clientSentence);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }

    }

}
