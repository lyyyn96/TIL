package test.collection;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("1");
		
		//제네릭을 사용하여 type checking, type casting 생략
		for(String s:list) {
			System.out.println(s);
		}
		
		/*
		ArrayList list = new ArrayList();
		//최초에 10칸 생성
		list.add("1");	//한번에 여러개 add 불가
		list.add("2");
		list.add("3");
		list.add("1");
		list.add(new ListTest());
		
		System.out.println(list);
		//위의 코드와 같은 결과. toString()이 overriding 된 것.
		//System.out.println(list.toString());
		System.out.println(list.size()); //크기 출력, 4
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)); //원소 출력
		}
		
		for(int i=0; i<list.size(); i++) {
			Object o = list.get(i);
			//String만 출력
			if(o instanceof String) {
				String s = (String)o;
				System.out.println(s);
			}
		}
		
		//불가
		//for(String s:list) {
		//	System.out.println(s);
		//}
		*/
	}
}
