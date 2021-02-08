package test.map;

import java.util.Enumeration;
import java.util.Hashtable;

public class MapTest {

	public static void main(String[] args) {
		Hashtable map = new Hashtable();
		//key는 겹치면 안됨
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "1");
		map.put("d", new MapTest());
		//map.put("d", this()); static 안에서는 this사용 불가

		System.out.println(map);
		System.out.println(map.size());
		
		//key를 알아야 key에 해당하는 value를 get할 수 있음
		Object o1 = map.get("a");
		Object o2 = map.get("c");
		System.out.println(o1==o2); //true
		
		Enumeration enu = map.keys();
		//hasMoreElements(): boolean type, 다음 값 있는지 여부 확인
		//nextElement(): key값 출력
		//get(Object key): value값 출력
		while(enu.hasMoreElements()) {
			Object o = enu.nextElement();
			System.out.println(o+":"+map.get(o));
		}
	}
}
