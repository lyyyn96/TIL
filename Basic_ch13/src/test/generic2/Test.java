package test.generic2;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Cat cat = new Cat();
		AnimalList<LandAnimal> zoo = new AnimalList();
		zoo.add(cat);
		//에러
		//zoo.add("java");
		
		Fish fish = new Fish();
		AnimalList<WaterAnimal> zoo2 = new AnimalList();
		zoo2.add(fish);
		//에러
		//zoo2.add(cat);

		AnimalList.cryingAnimalList(zoo);
		//에러
		//AnimalList.cryingAnimalList(zoo2);
		
	}
}

class AnimalList<T>{
	ArrayList<T> al = new ArrayList<T>();
	//모든 육지동물 울게 함
	static public void cryingAnimalList(AnimalList<? extends LandAnimal> al) {
		LandAnimal la= al.get(0);
		la.crying();
	}
	//동물 추가
	public void add(T o) {
		al.add(o);
	}
	//동물 리턴
	public T get(int index){
		return al.get(index);
	}
	//동물 삭제
	public void remove() {
		
	}
}

class WaterAnimal{
	public void swim() {
		System.out.println("수중동물");
	}
}

class Fish extends WaterAnimal{
	@Override
	public void swim() {
		System.out.println("지느러미를 움직임");
	}
}

class LandAnimal{
	public void crying() {
		System.out.println("육지동물");
	}
}

class Cat extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("냐옹냐옹");
	}
}

class Dog extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("멍멍");
	}
}

class Sparrow extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("짹짹");
	}
}