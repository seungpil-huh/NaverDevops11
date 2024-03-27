package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex1_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Set 인터페이스를 구현한 클래스로는 TreeSet, HashSet 이 있다
		 * Set 타입의 특징: 	1. 중복 데이터를 허용하지 않는다
		 * 					2. 비순차적이다
		 * 					3. TreeSet 은 오름차순으로 들어간다
		 * 					4. HashSet 은 그냥 자기 마음대로 들어간다
		 */
		
		// <Integer>: 제네릭, 해당 컬렉션에는 Integer 타입만 넣을수 있다.
		// 다른 타입을 넣을 경우, 컴파일 오류가 발생한다.
		//Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set1 = new TreeSet<>(); // 뒷부분 제네릭은 생략이 가능
		set1.add(100); // JDK5 이전에는 set1.add(new Integer(100)); 이라고 적었어야 했다.
		set1.add(78);
		set1.add(78);
		set1.add(100);
		set1.add(65);
		
//		Set<Integer> set2 = new HashSet<>();
//		set2.add(100);
//		set2.add(78);
//		set2.add(78);
//		set2.add(100);
//		set2.add(65);
		
		System.out.println("set1 의 데이터 개수: " + set1.size()); // 3개 (중복 데이터는 한번만 포함)
		System.out.println("** 출력 1 **");
		for (int n : set1) {
			System.out.println(n);
		}
		
//		System.out.println("set2 의 데이터 개수: " + set2.size());
//		System.out.println("** 출력 2 **");
//		for (int n : set2) {
//			System.out.println(n);
//		}
		
		System.out.println("** 출력 2 **");
		Iterator<Integer> iter = set1.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
