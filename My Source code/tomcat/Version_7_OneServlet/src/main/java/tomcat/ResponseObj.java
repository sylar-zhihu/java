package tomcat;

import java.io.PrintWriter;

import sun.ServletResponse;



/*
 * 作者:
 * 日期:2019年3月13日:下午10:02:21
 * 程序作用:服务器公司实现sun公司的接口
**/
public class ResponseObj implements ServletResponse{

    PrintWriter writer;


    @Override
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
        
    }

    @Override
    public PrintWriter getWriter() {
        return writer;
    }



}
