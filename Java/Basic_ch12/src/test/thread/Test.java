package test.thread;

public class Test {
	
	public static void main(String[] args) {
		A t1 = new A();
		A t2 = new A();
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		th1.start();
		th2.start();
		
		/*
		//t1 thread
		t1.start();
		//t2 thread
		t2.start();
		*/
	}
}

//이미 다른 class를 상속받았다면
//Runnable interface를 사용
//이 방법이 더 OOP적이다.
/*
class A implements Runnable{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(i+"+1="+(i+1));
		}
	}
}
*/


class A extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(getName()+":"+i+"+1="+(i+1));
			if(i==50) {
				suspend();
			}
		}
	}
}
