package test.static_;

public class Test2 {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		//System의 모든 멤버가 static이라 가능
		System.out.println(time);
		
		//private이라서 접근 불가
		//System s = new System();
	}
}
