package test.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTest {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("c:\\temp\\a.txt");
			br = new BufferedReader(fr);
			String oneLine = "";
			while((oneLine=br.readLine()) != null) {
				System.out.println(oneLine);
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
}
