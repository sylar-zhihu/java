package my_3_小组件;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * 作者:
 * 日期:2017年5月16日:下午3:48:55
 * 程序作用:一般使用成员变量的模式
**/
public class Button_demo_1 extends JFrame {
    // 组件
    JButton button = new JButton("按钮1");

    public static void main(String[] args) {
        // 设置名字
        Button_demo_1 frame = new Button_demo_1();

    }

    public Button_demo_1() {
        // 可见
        this.setVisible(true);
        // 设置大小
        this.setSize(800, 600);
        // 点击退出的时候会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 按钮
        this.add(button);
    }

}
