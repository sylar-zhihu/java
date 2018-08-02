package my_0_顶层容器_Frame;
import java.awt.Color;
import java.awt.Frame;

/*
 * 作者:
 * 日期:2017年5月16日:下午3:48:55
 * 程序作用:
**/
public class Frame_demo_1_基本 {
    
    public static void main(String[] args) {
        // 设置名字
        Frame frame=new Frame("my frame");
        //  设置大小
        frame.setSize(800, 600);
        // 设置颜色
        frame.setBackground(Color.blue);
        // 可见 默认是不可见的
        frame.setVisible(true);
        // 大小可变
        frame.setResizable(true);
        // 设置出现位置 左上角坐标
        frame.setLocation(0,0);
        // 设置上下左右四个点
        frame.setBounds(0, 0, 100, 100);
        
    }

}
