package my_3_小组件;

import java.awt.*;
import java.awt.event.*;
/*
 * 作者:
 * 日期:2017年5月17日:上午10:29:32
 * 程序作用:把文本框输入的文本输入到命令行
**/
public class TFActionEvent {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TFFrame();
    }

}

class TFFrame extends Frame {
    TFFrame() {
        TextField tf = new TextField();
        // 添加文本框
        add(tf);
        // 添加监听器
        tf.addActionListener(new TFActionListener());
        pack();
        setVisible(true);
    }
}

class TFActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // 拿到触发事件的对象
        TextField tf = (TextField) e.getSource();
        System.out.println(tf.getText());
        // 设置为空
        tf.setText("");
    }
}
