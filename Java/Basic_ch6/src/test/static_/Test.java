package test.static_;

public class Test {
	//Test t = new Test(); 해주지 않으면
	//memory에 올라가지 않았기 때문에 에러
	//int i=10;
	
	//static을 붙이면
	//Test t = new Test(); 해주지 않아도 됨
	static int i=10;
		
	public static void main(String[] args) {
		/*
		//Test t = new Test();
		//아래의 두 줄이 같음.
		//static은 객체 생성 없이도 사용할 수 있음.
		System.out.println(Test.i);
		System.out.println(i);
		*/
		
		/*
		A o1 = new A();
		o1.i++;
		o1.printI(); //11
		
		A o2 = new A();
		o2.i++;
		o2.printI(); //12
		*/
		
		/*
		A.i++;
		A.printI(); //11
		
		A.i++;
		A.printI(); //12
		
		A.printI(); //12
		*/
		
		A o1 = new A("최혜린");
		A.count++;
		
		A o2 = new A("홍길동");
		A.count++;
		
		A.printCount();
	}
}
/*
//한 소스 코드에 class를 1개 넘게 두는 것은 좋지 않음
class A{
	static int i = 10;
	
	static public void printI() {
		System.out.println(i);
	}
}
*/

class A{
	String name;
	static int count=0;
	static public void printCount() {
		System.out.println(count);
	}
	A(String name){
		this.name = name;
	}
}

