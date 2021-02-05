package test.shape;

public class Rectangle extends Shape{
	
	private int w, h;
	
	
	public int getW() {
		return w;
	}


	public void setW(int w) {
		if(w>0) {
			this.w = w;
		}else {
			System.out.println("너비(width)는 0보다 큰 수여야 합니다.");
		}
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		if(h>0) {
			this.h = h;
		}else {
			System.out.println("높이(height)는 0보다 큰 수여야 합니다.");
		}
	}

	//method 이름을 areaRec에서 area로 재정의
	public void area(){
		System.out.println("사각형의 넓이= "+(w*h));
	}
}
