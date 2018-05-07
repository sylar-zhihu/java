package var.string;
/*
 * 作者:
 * 日期:2017年5月4日:下午4:55:21
 * 程序作用:适合长度经常变的String会快很多倍
**/
public class StringBufferDemo {
    
    public static void main(String[] args) {
        // 初始化
        StringBuffer buffer=new StringBuffer();
        StringBuffer buffer2=new StringBuffer("ss");
        // 追加
        buffer.append("This is a StringBuffer");  
        // 返回子字符串在字符串中最先出现的位置，如果不存在，返回负数  
        System.out.println("sb.indexOf(\"is\")=" + buffer.indexOf("is"));
        // 返回子字符串在字符串中最后出现的位置，如果不存在，返回负数  
        System.out.println("sb.lastIndexOf(\"is\") = " + buffer.lastIndexOf("is"));  
        // substring方法截取字符串，可以指定截取的起始位置和终止位置  
        System.out.print("sb.substring(4,9)=" + buffer.substring(4, 9));  
        // 替换 把1-length替换成Integer
        buffer.replace(1, buffer.length(), "Integer");  
        System.out.println("testReplace: " + buffer.toString());
    }

}
