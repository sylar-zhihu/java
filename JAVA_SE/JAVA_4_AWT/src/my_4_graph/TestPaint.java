package my_4_graph;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new PaintFrame().launchFrame();
    }
}


class PaintFrame extends Frame {

    private static final long serialVersionUID = 3887755004730102488L;
    
    public void launchFrame() {
        setBounds(200, 200, 640, 480);
        setVisible(true);
    }
    // 会得到画笔 Graphics 每次重画的时候调用这个方法 是重载的
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        // 画个椭圆
        g.fillOval(50, 50, 30, 30);
        g.setColor(Color.green);
        // 画矩形
        g.fillRect(80, 80, 40, 40);
        g.setColor(c);
    }

}