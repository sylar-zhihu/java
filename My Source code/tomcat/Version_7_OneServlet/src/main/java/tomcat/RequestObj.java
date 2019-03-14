package tomcat;

import java.util.HashMap;

import sun.ServletRequest;


/*
 * 作者:
 * 日期:2019年3月13日:下午10:02:21
 * 程序作用:服务器公司实现sun公司的接口
**/
public class RequestObj implements ServletRequest{
    // 用来存放request参数
    HashMap<String, String> paraMap = new HashMap<String, String>();

    String path;
    
    @Override
    public String getParaValue(String key) {
        // TODO Auto-generated method stub
        return paraMap.get(key);
    }
    
    

    public RequestObj(String url) {
        // user?username=123&password=456
        if (url.contains("?")) {// 包含参数 开始封装
            String[] pathAndPara = url.split("\\?");
            // 得到路径
            path = pathAndPara[0];
            // 得到参数
            String paraString = pathAndPara[1];
            // 封装参数
            if (paraString.contains("&")) {// 多个参数
                String[] split = paraString.split("&");
                for (String string : split) {
                    String[] split2 = string.split("=");
                    paraMap.put(split2[0], split2[1]);
                }

            } else {// 单个参数
                String[] split = paraString.split("=");
                paraMap.put(split[0], split[1]);
            }

        }

    }








    
    

}
