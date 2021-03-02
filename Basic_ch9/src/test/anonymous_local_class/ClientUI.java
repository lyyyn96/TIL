package test.anonymous_local_class;

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
		
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ta.append("마우스 진입\n");
			}
		});
		
		//local class
		//가독성을 높이기 위함
		//익명 class
		//WindowAdapter라는 부모 class를 넣어줘야 함
		//이름만 넣는 것이고 구체화 된 하위 class를 만드는 것임
		//부모 class의 이름만 쓰고 자신의 이름은 없으므로 익명 class
		f.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
		});
		
		b1.addActionListener(new ActionListener(){

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
		});
		
		//하고 싶은 일이 같으므로 binding 됨
		tf.addActionListener(new ActionListener() {
			
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
		});
		
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
}
