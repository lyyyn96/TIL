package test.shape;

public class Circle extends Shape{
	private int radius;
	
	public int getRadius() {
		return radius;
	}

	//유효성 검사
	public void setRadius(int radius) {
		if(radius>0) {
			this.radius = radius;
		}
	}

	//method 이름을 areaCircle에서 area로 재정의
	public void area() {
		System.out.println("원의 넓이= "+(radius*radius*3.14));
	}
	
}
