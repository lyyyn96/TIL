package test.encapsulation;

public class MyProfile {
	String name="최혜린";
	MyDate birthday = new MyDate();
	
	public void setBirthday() {
		/* private 변수기 때문에 직접 값 변경은 불가
		birthday.year = 1996;
		birthday.month = 12;
		birthday.day = 11;
		*/
		
		//method를 통한 값 변경은 가능
		birthday.setYear(1996);
		birthday.setMonth(12);
		birthday.setDay(11);
	}
}
