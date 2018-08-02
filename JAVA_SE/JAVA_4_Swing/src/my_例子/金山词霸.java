package my_例子;
/*
 * 作者:
 * 日期:2017年5月22日:下午5:40:04
 * 程序作用:Jlabel可以放图片
**/
import java.awt.*;
import javax.swing.*;
public class 金山词霸 extends JFrame{
        //定义组件
        JSplitPane jsp;
        // JList(列表框)
        JList jl;
        JLabel jlb;
        public static void main(String[] args) {
                金山词霸 win=new 金山词霸();
}
        //构造函数
        public 金山词霸(){
                //建立组件
                String[] words={"boy","girl","bird","close"};
                jl=new JList(words);
                
                jlb=new JLabel(new ImageIcon("images/cb.jpg"));//访问时路径\\或/
                //拆分窗格
                jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jl,jlb);
                //可以收缩变化
                jsp.setOneTouchExpandable(true);
                
                //设定布局管理器(JFrame本身就是BorderLayout布局)
                
                //加入组件
                this.add(jsp);
                                
                //设置窗体
                this.setTitle("金山词霸2007");
                this.setSize(400, 300);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(true);
        }
}

