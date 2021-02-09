package test.innerclass;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ClientUI {

	//inner class를 위해 member 변수 이 부분에 선언
	TextArea ta;
	TextField tf;
	
	public void onCreate() {
		Frame f = new Frame("나의 채팅");
		Panel p = new Panel();
		Panel p1 = new Panel();
		Button b1 = new Button("전송1");
		Button b2 = new Button("전송2");
		JCheckBox jcb = new JCheckBox("Name",false);
		JRadioButton jrb= new JRadioButton("First");
		tf = new TextField(20);
		ta = new TextArea();
		//TextField tf = new TextField(20); //enter 불가
		//TextArea ta = new TextArea();
		
		WindowListener fHandler = new MyFrameHandler();
		f.addWindowListener(fHandler);
		
		MyButtonHandler b1Handler = new MyButtonHandler();
		//inner class
		//ClientUI ui = new ClientUI();
		//MyButtonHandler b1Handler = ui.new MyButtonHandler();
		b1.addActionListener(b1Handler);
		
		//하고 싶은 일이 같으므로 binding 됨
		tf.addActionListener(b1Handler);
		
		f.add(ta, BorderLayout.CENTER);
		f.add(p, BorderLayout.SOUTH);
		f.add(p1, BorderLayout.EAST);
		p.add(tf);
		p.add(b1);
		p1.add(b2);
		p1.add(jcb);
		p1.add(jrb);
		
		p.setBackground(Color.ORANGE);

		f.setBackground(Color.GRAY);
		f.setLocation(800, 200);
		f.setSize(400, 500);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
	
		ClientUI ui = new ClientUI();
		ui.onCreate();
	}
	
	//inner class
	//class를 독립적으로 만들지 않았으므로
	//member 변수를 전달하지 않아도 바로 사용가능
	public class MyButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//하고 싶은 일
			//Console창에 생김
			//System.out.println("Hello");
			//TextArea영역에 생김
			String msg = tf.getText();
			ta.append(msg+"\n");
			tf.setText("");
		}
	}
	
	//inner class
	public class MyFrameHandler extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing");
			System.exit(0);
		}
	}
}	
