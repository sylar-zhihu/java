package tomcat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


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

        BufferedReader clientSentenceReader = null;
        PrintWriter outToClientWriter = null;
        try {
            // 得到客户端数据的对象
            clientSentenceReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 回给客户端信息 对象 true 表示实时刷新
            outToClientWriter = new PrintWriter(socket.getOutputStream(), true);

            String clientSentence = null;
            // 在第一行中 得到第一行
            String requestLine = clientSentenceReader.readLine();
            // 获取请求的uri
            String uri = requestLine.split(" ")[1];
            // System.out.println("uri:"+uri);// /index2.html
            // 默认页面是.html结尾
            if (uri.endsWith(".html")) {
                responsePage(uri, outToClientWriter);
            }
            // 

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }

    }

    // 返回页面
    private void responsePage(String uri, PrintWriter outToClientWriter) throws IOException {
        // 去掉/
        String realuUri = uri.substring(1);
        System.out.println(realuUri);
        // 读取页面
        try {
            StringBuilder response=new StringBuilder();
            // 加入响应头 
            response.append("HTTP/1.1 200 OK\n");
            response.append("Content-Type: text/html; charset=utf-8\n\n");
            String page = IOUtils.toString(HanderRequestThread.class.getClassLoader().getResourceAsStream(realuUri));
            // 拼接页面
            response.append(page);
            // 返回响应
            outToClientWriter.print(response);
            // 强制刷新
            outToClientWriter.flush();
            System.out.println("页面存在");
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("页面不存在");
            // 404 
            StringBuilder response=new StringBuilder();
            response.append("HTTP/1.1 404 NotFound\n");
            response.append("Content-Type:text/html;charset=utf-8\n\n");
            String page = IOUtils.toString(HanderRequestThread.class.getClassLoader().getResourceAsStream("404.html"));
            response.append(page);
            // 返回响应
            outToClientWriter.print(response);
            System.out.println(response);
            outToClientWriter.flush();
            e.printStackTrace();
        }

    }

}
