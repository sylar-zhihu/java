package swing_demo;

import javax.swing.JFrame;

/*
 * 作者:
 * 日期:2016年11月26日:下午3:35:09
 * 程序作用:最底层的画布
**/
public class Dome_1 {
    
    public static void main(String[] args) {
        // 最底层容器
        JFrame jf =new JFrame();
        // 设置标题
        jf.setTitle("hello");
        jf.setSize(800, 600);
        // 初始位置
        jf.setLocation(100, 200);
        jf.setVisible(true);
    }

}
