package response.sun;

import java.io.PrintWriter;

/*
 * 作者:
 * 日期:2019年3月13日:下午10:09:18
 * 程序作用:Sun公司封装响应参数的接口
**/
public interface ServletResponse {
    
    public void setWriter(PrintWriter out);
    
    public PrintWriter getWriter();

}
