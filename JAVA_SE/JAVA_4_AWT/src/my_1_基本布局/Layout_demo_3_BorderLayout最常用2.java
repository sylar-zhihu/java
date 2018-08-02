package my_1_基本布局;

import java.awt.*;

public class Layout_demo_3_BorderLayout最常用2 {
    public static void main(String args[]) {
        Frame f;
        f = new Frame();
        Panel panel = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();
        Panel panel5 = new Panel();
        Label label = new Label("well come to Stock Portfolio Manager");
        panel.add(label);

        f.add(panel, BorderLayout.NORTH);
        f.add(panel4, BorderLayout.EAST);
        f.add(panel2, BorderLayout.SOUTH);
        f.add(panel3, BorderLayout.WEST);

        f.add(panel5, BorderLayout.CENTER);

        f.setSize(200, 200);
        f.setVisible(true);
    }
}
