package reflex_demo;

import java.lang.reflect.Method;

public class Fan_She_5_Methed {

    public static void main(String[] args) throws Exception {
        String string = "abc";
        // 得到方法的Method对象 一个是方法名 第二个是方法的参数
        Method methodCharAt = String.class.getMethod("charAt", int.class);
        // 调用方法
        System.out.println(methodCharAt.invoke(string, 1));
        // 静态方法调用 不需要对象使用null
        System.out.println(methodCharAt.invoke(null, 1));
    }

}
