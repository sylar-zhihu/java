package reflex_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 作者:
 * 日期:2016年12月5日:下午3:30:50
 * 程序作用:得到构造方法和成员变量
**/
public class Reflex_2_Constract {

    public static void main(String[] args) throws Exception {
        // 得到构造方法 参数为函数参数的类字节码
        Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
        // 用构造方法得到对象
        String str = constructor.newInstance(new StringBuffer("abc"));
        System.out.println(str.charAt(2));// c
        // 不带参数的构造方法
        String string = (String) Class.forName("java.lang.String").newInstance();
        System.out.println(string);

    }

}
