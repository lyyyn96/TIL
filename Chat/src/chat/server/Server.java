package chat.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
	ArrayList<DataOutputStream> allClientOutput = new ArrayList<DataOutputStream>();
	
	public void broadcast(String msg) {
		synchronized(allClientOutput) {
			for(DataOutputStream out:allClientOutput) {
				try {
					out.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void chatProcess() {
		try {
			//0-65565, 1024번까지는 시스템 포트
			//21:FTP, 23:telnet, 80:HTTP
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("server ready...");
			while(true) {
				Socket s = ss.accept();
				System.out.println(s.getInetAddress()+"님 접속");
				DataInputStream in = new DataInputStream(s.getInputStream());
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				allClientOutput.add(out);
				ServerThread t = new ServerThread(in,out,s);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server().chatProcess();
	}
	
	class ServerThread extends Thread{
		DataInputStream in;
		DataOutputStream out;
		Socket s;
		
		public ServerThread(DataInputStream in, DataOutputStream out, Socket s) {
			this.in = in;
			this.out = out;
			this.s = s;
		}
		@Override
		public void run() {
			String msg = "";
			try{
				while(true) {
					msg = in.readUTF();
					//out.writeUTF(msg); //broadcast가 아님, 자신에게만 에코
					broadcast(msg);
				}
			}catch(IOException e) {
				//해당 Client가 접속 종료
				//사용하던 자원을 종료하는게 좋음
				//생성한 역순으로 종료하는게 좋음
				try {
					if(out != null) {
						out.close();
						synchronized (allClientOutput) {
						allClientOutput.remove(out);
						}
					}
					if(in != null) in.close();
					if(s != null) s.close();
				}catch(IOException ex) {
					
				}
			}
			System.out.println(msg);
		}
	}
}
