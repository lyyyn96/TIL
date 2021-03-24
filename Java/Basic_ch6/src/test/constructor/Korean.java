package test.constructor;

public class Korean {
	
	String nation = "대한민국";
	String name;
	String ssn;
	
	public Korean() {
		//앞에 super(); 들어가지 않음.
		//왜냐하면 this()와 super()는 생성자 첫 줄에 위치해야 하므로
		//this()나 super() 둘 중 하나만 사용할 수 있음.
		this("홍길동", "920202-1542365");
		//Korean("홍길동", "920202-1542365"); 불가능
	}
	
	public Korean(String name, String ssn) {
		//this(); 하면 재귀가 일어나서 에러남
		this.name = name;
		this.ssn = ssn;
	}
}
