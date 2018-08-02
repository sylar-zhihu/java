package my_0_顶层容器_Frame;
import java.awt.Color;
import java.awt.Frame;

/*
 * 作者:
 * 日期:2017年5月16日:下午3:48:55
 * 程序作用:把参数传入构造函数，封装成一个新的类
**/
public class Frame_demo_2_封装 {

}

class Myframe extends Frame {

    Myframe(int x, int y) {
        this.setLocation(x, y);

    }

}
