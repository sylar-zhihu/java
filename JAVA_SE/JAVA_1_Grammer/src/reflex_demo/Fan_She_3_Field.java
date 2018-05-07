package reflex_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 作者:
 * 日期:2016年12月5日:下午3:30:50
 * 程序作用:Field使用 相当于属性
**/
public class Fan_She_3_Field {

    public static void main(String[] args) throws Exception {

        // 成员变量
        ReflectPoint pt1 = new ReflectPoint(10, 8);
        // getField()得到public成员变量的Field private无法取得
        Field fieldy = pt1.getClass().getField("y");
        // 通过Field得到对象的成员变量的值
        System.out.println(fieldy.get(pt1));// 8
        // getDeclaredField()得到私有的变量
        Field fieldx = pt1.getClass().getDeclaredField("x");
        // 暴力反射
        fieldx.setAccessible(true);
        System.out.println(fieldx.get(pt1));// 10

    }

}

class ReflectPoint {
    /*
     * 辅组类
     */
    private int x;

    public int y;

    public ReflectPoint(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

}
