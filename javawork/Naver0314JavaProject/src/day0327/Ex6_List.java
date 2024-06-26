package day0327;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex6_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new Vector<String>();
		//List<String> list2 = new Vector<String>(5); // 5개가 넘을 경우 10개로 할당 값 변경
		List<String> list2 = new Vector<String>(5,3); // 5개가 넘을 경우 8개로 할당 값 변경
		
		System.out.println("list1 데이터 개수: " + list1.size());
		System.out.println("list1 의 할당된 개수: " + ((Vector<String>)list1).capacity()); // capacity 는 오버라이드 메소드가 아니고 vector 가 갖고있는 메소드
		
		System.out.println("list2 데이터 개수: " + list2.size());
		System.out.println("list2 의 할당된 개수: " + ((Vector<String>)list2).capacity()); // capacity 는 오버라이드 메소드가 아니고 vector 가 갖고있는 메소드
		
		String str[] = {"red", "blue", "green", "white", "red", "yellow", "pink"};
		// list1, list2 에 배열 데이터 추가
		for (String s : str) {
			list1.add(s);
			list2.add(s);
		}
		
		System.out.println("=".repeat(20));
		System.out.println("list1 데이터 개수: " + list1.size());
		System.out.println("list1 의 할당된 개수: " + ((Vector<String>)list1).capacity()); // capacity 는 오버라이드 메소드가 아니고 vector 가 갖고있는 메소드
		
		System.out.println("list2 데이터 개수: " + list2.size());
		System.out.println("list2 의 할당된 개수: " + ((Vector<String>)list2).capacity()); // capacity 는 오버라이드 메소드가 아니고 vector 가 갖고있는 메소드
		
		System.out.println("** 출력 1 **");
		for (String s : list1) {
			System.out.println(s);
		}
		
		System.out.println("** 출력 2 **");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println((i + 1) + ":" + list1.get(i));
		}
		
		System.out.println("** 출력 3 **");
		Iterator<String> iter = list1.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("** 출력 4 **");
		Object ob[] = list1.toArray();
		for (Object s : ob) {
			System.out.println((String)s);
		}
	}

}
