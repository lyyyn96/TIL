package test.collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		//에러
		//set.add(new SetTest());
		//set.add(new SetTest());
		set.add("1");
		
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			String o = ite.next();
			System.out.println(o);
		}
		
		/*
		HashSet set = new HashSet();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add(new SetTest());
		set.add(new SetTest());
		set.add("1");
		
		//넣은 순서대로 나오는 것이 아니라 랜덤 순서로 나옴
		System.out.println(set);
		//Set은 중복 불가
		System.out.println(set.size()); //크기 출력, 5
		
		//Set은 순서가 없어서 get할 수 없음. Iterator 사용
		Iterator ite = set.iterator();
		System.out.println(ite); //Iterator 주소 값 출력
		//hasNext(): boolean type, 다음 값 있는지 여부 확인
		//next(): 값 출력
		while(ite.hasNext()) {
			Object o = ite.next();
			System.out.println(o);
		}
		*/
	}
}
