package test.generic;

import java.util.*;
//import java.util.ArrayList;
//import java.util.List;

public class Test {

	public static void main(String[] args) {
		//resize 가능
		//size에 변경이 생기면 새로운 객체가 생성되고
		//arraycopy가 자동으로 됨
		List<String> list = new ArrayList();
		list.add("Hi");
		//String type이 와야 하므로 불가
		//List list = new ArrayList<String>();이면 가능
		//따라서 선언시에 <String> 해줘야 함
		//list.add(new Object());
		
		//아래의 코드와 유사. 하지만 resize 불편
		//자동으로 arraycopy가 되지 않아 수동으로 해야 함
		String []arr = new String[10];
		arr[0] = "Hi";

		/*
		List list2 = new ArrayList();
		//Wrapper class
		//primitive type(그 자체로 값을 가짐. method는 없음)을
		//reference type(data, method가짐)으로 변환하고 싶을 때
		Integer o1 = new Integer(1);
		Integer o2 = new Integer(2);
		list2.add(o1);
		list2.add(o2);
		//Auto-boxing
		//Wrapper class를 사용하는 것이 원칙이기는 하지만 java5(1.5버전)부터
		//자동으로 reference type으로 변환시켜 넣어주기 시작
		list2.add(1);
		
		List<Integer> list3 = new ArrayList();
		//Unboxing
		//reference type에서 primitive type으로 자동 변환
		//Auto-boxing과 Unboxing 둘 다 성능이 저하됨
		int i = list3.get(2);
		*/
		
		/*
		//compile error는 아니지만 run time error
		Object []array = new Long[10];
		array[0]="Hi";
		array[1]=new Integer(1);
		array[2]=new Long(2L);
		*/
	}
}
