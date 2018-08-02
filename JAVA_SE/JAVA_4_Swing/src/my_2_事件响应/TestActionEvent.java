package my_2_事件响应;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent {
    public static void main(String args[]) {
        Frame f = new Frame("Test");
        Button button = new Button("Press Me!");
        // 自己定义的对象 实现了ActionListener接口
        ActionEventMonitor monitor = new ActionEventMonitor();
        // 给按钮加一个监听对象
        button.addActionListener(monitor);
        f.add(button, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}

// 监听对象 处理事件 自己定义 实现了ActionListener接口
class ActionEventMonitor implements ActionListener {
    //  具体的信息在ActionEvent中
    public void actionPerformed(ActionEvent e) {
        // 输出Butten的名字
        System.out.println(e.getActionCommand());
    }
}
