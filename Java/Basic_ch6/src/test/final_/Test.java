package test.final_;

public class Test {

	public static void main(String[] args) {
		/*
		A b = new B();
		b.i++;
		System.out.println(b.i);
		b.printI();
		*/
		
		//toString과 equals method는 오버라이딩 된 것임
		//Object class의 toString과 equals는 주소값, 주소값 비교
		Object o1 = new Object();
		System.out.println(o1.toString());
		Object o2 = new Object();
		System.out.println(o2.toString());
		System.out.println(o1==o2); //주소값 비교
		System.out.println(o1.equals(o2));
		
		Test t1 = new Test();
		System.out.println(t1.toString());
		Test t2 = new Test();
		System.out.println(t2.toString());
		System.out.println(t1==t2);
		System.out.println(t1.equals(t2));
		
		//String class의 toString과 equals는 내용값, 내용값 비교
		String s1 = new String("java");
		System.out.println(s1.toString());
		String s2 = new String("java");
		System.out.println(s2.toString());
		System.out.println(s1==s2); //주소값이 다름
		System.out.println(s1.equals(s2));
		
		String s3 = "java";
		System.out.println(s3.toString());
		String s4 = "java";
		System.out.println(s4.toString());
		System.out.println(s3==s4); //주소값이 같음
		System.out.println(s3.equals(s4));
	}
}

//class 앞에 final 붙이면 상속 불가
class A{
	//변수 앞에 final 붙이면 변수의 값 변경이 불가. 상수가 됨
	final int i = 10;
	public void printI() {
		System.out.println("A의 i는 "+i);
	}
}

class B extends A{
	//int i = 100;
	public void printI() {
		System.out.println("A로부터 상속받은 i는 "+i);
	}
}

//String의 주소 값을 파악하고 싶어서 아래의 class를 만들기가 불가능
//String 자체가 final이기도 해서 불가능
/*
class MyString extends String{
	public String toString() {
		//super 두 번 연속은 불가능함. 상위로 올라가서 super해야 함
		super.super.toString();
	}
}
*/



