package my_2_jpanel;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 作者:
 * 日期:2017年5月16日:下午4:02:59
 * 程序作用:
**/
public class JPanel_demo_1_基本 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Java Frame with Panel");
        JPanel panel = new JPanel();
        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(new Color(0, 0, 102));
        // 相对于frame的坐标
        panel.setBounds(50, 50, 400, 400);
        panel.setBackground(new Color(204, 204, 255));
        //  panel加入到Frame
        frame.add(panel);
    }

}
