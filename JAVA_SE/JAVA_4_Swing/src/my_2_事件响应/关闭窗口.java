package my_2_事件响应;

import java.awt.*;
import java.awt.event.*;

public class 关闭窗口 {
    public static void main(String args[]) {
        new MyFrame55("MyFrame");
    }
}

class MyFrame55 extends Frame {
    private static final long serialVersionUID = 5819858325377506443L;

    MyFrame55(String s) {
        super(s);
        setLayout(null);
        setBounds(300, 300, 400, 300);
        this.setBackground(new Color(204, 204, 255));
        setVisible(true);
       
        // 这里使用了匿名内部类
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(-1);
            }
        });

    }
  
}
