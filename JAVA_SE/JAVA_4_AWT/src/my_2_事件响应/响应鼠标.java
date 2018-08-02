package my_2_事件响应;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class 响应鼠标 {
    public static void main(String args[]) {
        new MyFrame("drawing...");
    }
}

class MyFrame extends Frame {
    private static final long serialVersionUID = 9125622475350972974L;

    ArrayList<Point> points = null;

    MyFrame(String s) {
        super(s);
        points = new ArrayList<Point>();
        setLayout(null);
        setBounds(300, 300, 400, 300);
        this.setBackground(new Color(204, 204, 255));
        setVisible(true);
        // 添加鼠标监听
        this.addMouseListener(new MouseMonitor());
    }

    public void paint(Graphics g) {
        Iterator<Point> i = points.iterator();
        while (i.hasNext()) {
            Point p = (Point) i.next();
            g.setColor(Color.BLUE);
            g.fillOval(p.x, p.y, 10, 10);
        }
    }

    public void addPoint(Point p) {
        points.add(p);
    }
}

// 新建一个类继承鼠标监听 
// MouseAdapter 实现了MouseListener 既可以继承 又可以实现
// 继承简单一点，因为接口有5个方法，继承不用重写所有方法
class MouseMonitor extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        MyFrame f = (MyFrame) e.getSource();
        f.addPoint(new Point(e.getX(), e.getY()));
        f.repaint();
    }
}
