package chat.client;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ClientUI {

	TextArea ta;
	TextField tf;
	DataOutputStream out;
	DataInputStream in;
	String chatId;
	
	class ClientThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					//채팅 메세지 읽기
					ta.append(in.readUTF()+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//채팅 메세지 보내기
	public void chatMsg() {
		String msg=tf.getText();
		try {
			out.writeUTF(chatId+" "+msg); // [혜린]안녕?
		} catch (IOException e) {
			e.printStackTrace();
		}
		tf.setText("");
	}
	
	public void onCreate() {
		Frame f = new Frame("나의 채팅");
		Panel p = new Panel();
		//Panel p1 = new Panel();
		Button b1 = new Button("채팅");
		//Button b2 = new Button("전송2");
		//JCheckBox jcb = new JCheckBox("Name",false);
		//JRadioButton jrb= new JRadioButton("First");
		tf = new TextField(20);
		ta = new TextArea();
		MenuBar mb = new MenuBar();
		Menu file_menu = new Menu("파일");
		Menu edit_menu = new Menu("편집");
		MenuItem open_item = new MenuItem("열기");
		MenuItem save_item = new MenuItem("저장");
		
		mb.add(file_menu);
		mb.add(edit_menu);
		f.setMenuBar(mb);
		file_menu.add(open_item);
		file_menu.add(save_item);
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				FileDialog save = new FileDialog(f, "저장 창", FileDialog.SAVE);
				save.setVisible(true); //container계열은 보여달라고 해야 함
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(save.getDirectory() + save.getFile());
					fw.write(ta.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						if(fw != null) fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				System.out.println("file open?");
				FileDialog open = new FileDialog(f, "열기 창", FileDialog.LOAD);
				open.setVisible(true); //container계열은 보여달라고 해야 함
				
				FileReader fr = null;
				BufferedReader br = null;
				try {
					//선택한 파일의 경로 이름이 나옴
					fr = new FileReader(open.getDirectory()+open.getFile());
					br = new BufferedReader(fr);
					String oneLine = "";
					ta.setText("");
					while((oneLine=br.readLine()) != null) {
						ta.append(oneLine+"\n");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {//종료하는 코드 반드시 넣어줘야 함
					try {//예외로 if에 중괄호 안함
						if(br != null) br.close();
						if(fr != null) fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		/*
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ta.append("마우스 진입\n");
			}
		});
		*/
		
		f.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
		});

		//b1.addActionListener(e ->chatMsg());

		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 채팅 서버 연결
				chatId = "["+tf.getText()+"]";
				ta.setText(chatId+"님 채팅을 시작합니다.\n");
				
				try {
					Socket s = new Socket("localhost",9999);
					out = new DataOutputStream(s.getOutputStream());
					in = new DataInputStream(s.getInputStream());
					ClientThread t = new ClientThread();
					t.start();
					ta.append("연결 ok\n");
					tf.setText("");
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//하고 싶은 일이 같으므로 binding 됨
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//하고 싶은 일
				chatMsg();
			}
		});
		
		f.add(ta, BorderLayout.CENTER);
		f.add(p, BorderLayout.SOUTH);
		//f.add(p1, BorderLayout.EAST);
		p.add(tf);
		p.add(b1);
		//p1.add(b2);
		//p1.add(jcb);
		//p1.add(jrb);
		
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
