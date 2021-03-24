package test.shape;

public class Printer {
	/*
	public void print(Object o) {
		
		//문제점 1.개발 불편
		//문제점 2.확장성 X
		//문제점 3.if와 type casting으로 인한 성능 저하
		//이를 해결하기 위해 shadow effect를 우회해야 하는 상황이 옴
		//그것이 바로 overriding
		if(o instanceof Circle) {
			Circle c = (Circle)o; //명시적 캐스팅
			c.radius = 5;
			c.areaCircle();
		}else if(o instanceof Rectangle) {
			Rectangle r = (Rectangle)o;
			r.h = 3;
			r.w = 4;
			r.areaRect();
		}else if(o instanceof Triangle) {
			Triangle t = (Triangle)o;
			t.h = 8;
			t.w = 2;
			t.areaTri();
		}
	}
	*/
	/*
	//Shape에 해당하는 것만 걸러줌
	//하지만 여전히 if문, type casting과 
	//확장성 문제가 사라지지 않는다.
	public void print(Shape o) {
		if(o instanceof Circle) {
			Circle c = (Circle)o; //명시적 캐스팅, shadow effect 해제
			c.radius = 5;
			c.areaCircle();
		}else if(o instanceof Rectangle) {
			Rectangle r = (Rectangle)o;
			r.h = 3;
			r.w = 4;
			r.areaRec();
		}else if(o instanceof Triangle) {
			Triangle t = (Triangle)o;
			t.h = 8;
			t.w = 2;
			t.areaTri();
		}
	}
	*/
	/*
	//오버로딩(overloading)을 사용
	//확장성 문제가 여전함
	public void print(Circle c){
		c.radius=5;
		c.areaCircle();
	}
	public void print(Rectangle r){
		r.w=3;
		r.h=4;
		r.areaRecangle();
	}
	public void print(Triangle t){
		t.w=8;
		t.h=2;
		t.areaTriangle();
	}
	*/
	//오버라이딩(overriding)으로 해결
	//성능을 높이고 확장성을 늘리기 위해서
	public void print(Shape s) {
		s.area();
	}
	
	/*
	//Circle class의 경우에는 Shape와 Circle type 둘 다 해당
	//out.print(c); 할 때 Circle type에 더 가까운
	//Shape보다 Circle type을 받아들이는 아래의 method가 호출
	//위의 method를 받고 싶으면
	//Test class에서 out.print(Shape(c)); 라고 해야 함
	public void print(Circle c) {
		System.out.println(c.getRadius());
	}
	*/
}
