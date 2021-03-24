package test.constructor;

public class A extends Object{
	
	private int i;
	private String s;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public A() {
		super();
		System.out.println("A() 생성자 호출");
	}
	
	public A(int i) {
		super();
		System.out.println("A(int i) 생성자 호출");
	}
	
	/*
	public A(int i, String s) {
		super();
		System.out.println("A(int i, String s) 생성자 호출");
	}
	*/
	
	public A(int i, String s) {
		//super();는 맨 앞 줄에 있어야 함
		//super();는 작성하지 않아도 알아서 컴파일러가 넣어줌
		super();
		//유효성 검사를 하지 않기 때문에 이와 같은 방식은 좋지 않음.
		//따라서 set method를 만들어서 호출해야 함.
		//this.i = i;
		//this.s = s;
		setI(i);
		setS(s);
		System.out.println("A(int i, String s) 생성자 호출");
	}
	
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A(10);
		A a3 = new A(10, "java");
		//a3.setI(10);
		//a3.setS("java");
		//A a4 = new A(10.0); double type이라 불가능
		A a5 = new A((int)10.0);
	}
}
