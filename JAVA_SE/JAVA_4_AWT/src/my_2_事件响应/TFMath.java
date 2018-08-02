package my_2_事件响应;

import java.awt.*;
import java.awt.event.*;
/*
 * 作者:
 * 日期:2017年5月17日:上午10:29:32
 * 程序作用:使用了内部内，因为得不到Frame里面的变量，所以使用内部类
**/
public class TFMath {
    public static void main(String[] args) {
        new TFFrame().launchFrame();
    }
}

class TFFrame extends Frame {
    TextField num1, num2, num3;

    public void launchFrame() {
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(15);
        Label lblPlus = new Label("+");
        Button btnEqual = new Button("=");
        btnEqual.addActionListener(new MyMonitor());
        setLayout(new FlowLayout());
        add(num1);
        add(lblPlus);
        add(num2);
        add(btnEqual);
        add(num3);
        pack();
        setVisible(true);
    }

    private class MyMonitor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText("" + (n1 + n2));
        }
    }

}

