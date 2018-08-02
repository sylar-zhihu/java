package my_2_事件响应;

import java.awt.*;
import java.awt.event.*;

public class 键盘事件 {
    public static void main(String[] args) {
        new KeyFrame().launchFrame();
    }
}

class KeyFrame extends Frame {

    private static final long serialVersionUID = -8184919111315638466L;

    public void launchFrame() {
        setSize(200, 200);
        setLocation(300, 300);
        addKeyListener(new MyKeyMonitor());
        setVisible(true);
    }

    class MyKeyMonitor extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            // 得到暗下键盘的keyCode
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_C) {
                System.out.println("C");
            }
        }
    }
}
