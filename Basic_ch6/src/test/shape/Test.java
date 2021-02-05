package test.shape;

public class Test {

	public static void main(String[] args) {
		Circle c = new Circle();
		c.setRadius(5);
		Rectangle r = new Rectangle();
		r.setH(7);
		r.setW(4);
		Triangle t = new Triangle();
		t.setH(6);
		t.setW(8);
		Printer out = new Printer();

		out.print(c);
		out.print(r);
		out.print(t);
		//out.print("java"); //"java"는 Object o에 해당하지 않으므로 출력 안됨
						     //Shape o로 바꿨을 경우에는 컴파일 에러가 남.
						     //이것이 좋음. robust하다고 함. 실행 시에 오류를 줄여 줌
						     //실행 시에 오류를 줄여 줌. 의도를 제대로 반영
						     //java는 이처럼 엄격하여 안정성이 높음
	}
}
