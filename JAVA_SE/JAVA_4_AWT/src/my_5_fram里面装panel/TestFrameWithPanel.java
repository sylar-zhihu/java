package my_5_fram里面装panel;

import java.awt.*;

public class TestFrameWithPanel {
    public static void main(String args[]) {
        Frame f = new Frame("MyTest Frame");
        Panel pan = new Panel();
        f.setSize(200, 200);
        f.setBackground(Color.blue);
        f.setLayout(null);
        pan.setSize(100, 100);
        pan.setLocation(50, 50);
        pan.setBackground(Color.green);
        f.add(pan);
        f.setVisible(true);
    }
}