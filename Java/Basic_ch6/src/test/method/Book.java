package test.method;

public class Book {
	/*
	public void want(String all[]) {
		for(int i=0; i<all.length; i++) {
			System.out.println(all[i]);
		}
		/*
		Enhanced for(향상된 for문)
		for(String s:all) {
			System.out.println(s);
		}
	
	}
	*/
	public void want(String ... all) {
		//all을 찍으면 주소 값이 출력
		System.out.println(all);
		for(int i=0; i<all.length; i++) {
			System.out.println(all[i]);
		}
	}
	
	public void test() {
		want();
	}
	
	//overloading
	public void test(int i) {
		want();
	}
	
	//overloading
	public int test(int i, int j) {
		return 0;
	}
}
