package my_1_基本布局;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/*
 * 作者:
 * 日期:2017年5月16日:下午5:08:45
 * 程序作用:
**/
public class Layout_demo_1_FlowLayout {
    public static void main(String[] args) {
        Frame f = new Frame("Flow Layout");
        Button button1 = new Button("Ok");
        Button button2 = new Button("Open");
        Button button3 = new Button("Close");
        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.add(button1);
        f.add(button2);
        f.add(button3);
        f.setSize(100, 100);
        f.setVisible(true);
    }

}
