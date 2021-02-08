package test.string;

public class Test {

	public static void main(String[] args) {
		String s1 = new String("java");
		String s2 = new String("java");
		String s3 = "java";
		String s4 = "java";
		
		s1=s1.concat("1"); //이전의 번지수를 가리키는 선을 끊고(garbage)
						   //새로운 번지수를 가리킴
		s2.concat("1"); //할당을 받지 않았기 때문에 가리키는 선이 안생김
		s3.concat("1"); //eden 영역과 달리 string literal pool은
						//변경된 객체마저 공유해서 사용
		s4.concat("1");
		
		//java가 출력
		//배열은 resize가 안되기 때문에
		//원본이 바뀌지 않음(원본 변경 불가, immutable)
		//따라서 concat을 하면 배열의 크기가 resize된 새로운 String 객체가 생성 
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		String s5 = s2.concat("1");
		System.out.println(s5); //java1
		System.out.println(s5==s2); //false
		
		//StringBuffer가 java라는 4개의 칸이 아니라 16칸을 공간 할당
		//StringBuffer가 다 차면 두배 늘어난(16*2=32개) 칸을 가진 객체를
		//새로 생성하고 새롭게 생성한 객체를 가리키게 됨
		StringBuffer sb1 = new StringBuffer("java");
		StringBuffer sb2 = sb1.append("1");
		
		System.out.println(sb1); //java1
		System.out.println(sb2); //java1
		System.out.println(sb1==sb2); //true
		
		StringBuilder sb3 = new StringBuilder("java");
		StringBuilder sb4 = sb3.append("1");
		
		System.out.println(sb3); //java1
		System.out.println(sb4); //java1
		System.out.println(sb3==sb4); //true
	}
}
