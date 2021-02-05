package test.encapsulation;

public class MyDate {
	private int year;	//data를 외부에서 변경하는 것을 방지
	private int month;
	private int day;
	
	/*
	//유효성 검사 부분에서는 return type이 없는 것(void)을 권장함
	String setYear(int newYear){
		//유효성 검사
		//MyProfile.class와 MyDate.class가 같은 컴퓨터가 아니라
		//분산시스템이면 MyDate.class를 가지고 있는
		//컴퓨터에만 잘못된 년도라고 출력이 됨
		//따라서 출력이 아니라 return을 해주는 것이 좋음
		//return 값을 주는 경우에는
		//return에 도달해야 하기 때문에
		//else문에만 return을 해주는 것이 아니라
		//if문에도 return을 해줘야 함
		if(newYear>0 && newYear<2022) {
			year = newYear;
			return "정상 입력되었습니다.";
		}else { 
			return "잘못된 년도입니다.";
		}
	}
	*/

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int newYear) {
		if(newYear>0 && newYear<2022) {
			year = newYear;
		}else {
			System.out.println("invalid year");
		}
	}
	
	public void setMonth(int month) {
		//유효성 검사
		//this는  해당 class의 member 변수를 가르킨다.
		if(month>0 && month<13) {
			this.month = month;
		}else {
			System.out.println("invalid month");
		}
	}

	public void setDay(int day) {
		//유효성 검사
		if(day<0 && day<32) {
			this.day = day;
		}else {
			System.out.println("invalid day");
		}
	}
}
