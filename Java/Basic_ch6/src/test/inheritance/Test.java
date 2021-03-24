package test.inheritance;

public class Test extends Object{

	public static void main(String[] args) {
		
		Object o = new Object();
		System.out.println(o.toString());
		
		A a = new A();
		a.i++;
		a.printI();
		//toString()은 주소 값을 return하는 method
		System.out.println(a);
		System.out.println(a.toString()); //위와 같은 결과
		
		B b = new B();
		b.x++;
		b.printX();
		b.i++;
		b.printI(); //상속 받은 것이 아니라 자신의 것을 출력
		System.out.println(b);
		System.out.println(b.toString());
	}
}
