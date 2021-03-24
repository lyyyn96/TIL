package test.method;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book();
		book.want(args);
		
		//public void want(String all[])이라면
		//book.want("a","b","c");는 에러
		//public void want(String ... all)로 수정해야 함
		//아니면 아래와 같이 써줘야 함
		String bookList[] = {"a","b","c"};
		book.want(bookList);
		
		book.test();
	}
}
