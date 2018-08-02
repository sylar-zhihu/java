package my_1_布局管理器;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;
public class Layout_demo_3_BorderLayout {
	public static void main(String args[]) {
		JFrame f;
		f = new JFrame("Border Layout");
		Button bn = new Button("BN");
		Button bs = new Button("BS");
		Button bw = new Button("BW");
		Button be = new Button("BE");
		Button bc = new Button("BC");


		f.add(bn, BorderLayout.NORTH);
		f.add(bs, BorderLayout.SOUTH);
		f.add(bw, BorderLayout.WEST);
		f.add(be, BorderLayout.EAST);
		f.add(bc, BorderLayout.CENTER);
		
		f.setSize(200,200);
		f.setVisible(true);
	}
}
