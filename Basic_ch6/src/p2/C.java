package p2;

import p1.A; //C와 A의 package가 다르기 때문에 import해줘야 함

public class C {
	public static void main(String[] args) {
		//import p1.A; 을 작성하지 않은 경우에는 이렇게 할 수 있음
		//p1.A obj1 = new p1.A();
		A obj1 = new A();
		
		System.out.println(obj1.i);
	}

}
