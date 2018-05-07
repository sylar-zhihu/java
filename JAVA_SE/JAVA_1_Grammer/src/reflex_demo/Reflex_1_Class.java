package reflex_demo;

import java.lang.reflect.Method;

/*
 * 作者:
 * 日期:2016年12月5日:下午3:30:50
 * 程序作用:字节码
**/
public class Reflex_1_Class {

    public static void main(String[] args) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        String str = "abc";
        // 得到字节码 三种都是String类的字节码
        Class class1 = str.getClass();
        Class class2 = String.class;
        Class class3 = Class.forName("java.lang.String");
        // 相等
        System.out.println(class1 == class2);// true
        System.out.println(class3 == class2);// true
        // 是否是基本类型
        System.out.println(class1.isPrimitive());// false
        System.out.println(int.class.isPrimitive());// true
        // 基本类型和包装类型
        // false 基本类型和包装类型字节码不同
        System.out.println(int.class == Integer.class);// flase
        // 使用TYPE得到基本类型的字节码
        System.out.println(int.class == Integer.TYPE);// true
        // 是不是数字
        System.out.println(int[].class.isArray());// true

    }

}
