package day0322;

class Apple {
	String msg = "Happy Day!!"; // 인스턴스 멤버 변수
	static String message = "오늘은 금요일"; // static 멤버 변수 (= 클래스 멤버 변수)
}

class Banana {
	static int kor = 100;
	static int eng = 80;
	String name = "마이클";
}

public class Ex1_Object {
	// 멤버 변수들
	String name = "홍길동";
	final static int MAX = 100; // static 변수

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static 멤버 메소드는 static 멤버 변수나 static 멤버 메소드만 접근이 가능하다
		 * 일반 인스턴스 메소드나 변수를 접근하기 위해서는 new 로 생성 후에
		 * 그 변수를 이용해서 호출해야만 한다
		 */
		// System.out.println(name); // 오류 발생
		System.out.println(Ex1_Object.MAX); // static 변수는 클래스명.변수명
		System.out.println(MAX); // 같은 클래스일 경우는 앞에 클래스명은 생략이 가능하다
		
		// name 을 출력하려면 new 생성한 인스턴스 변수가 필요하다
		Ex1_Object ex = new Ex1_Object();
		// ex 가 인스턴스 변수이다. 이 변수를 이용해야만 name 이 접근이 가능하다
		System.out.println(ex.name);
		
		// Apple 이 가진 2개의 멤버 변수를 출력해보세요
		System.out.println(Apple.message); // static 변수
		
		Apple a = new Apple(); // 인스턴스 변수를 출력하려면 객체 생성이 필요
		System.out.println(a.msg); // 인스턴스 변수
		
		// Banana 클래스의 kor, eng 점수를 출력하고 합계도 출력하세요
		int sum = Banana.kor + Banana.eng;
		System.out.println("국어점수: " + Banana.kor);
		System.out.println("영어점수: " + Banana.eng);
		System.out.println("합계: " + sum);
		
		// Banana 클래스의 name 도 출력하세요
		Banana b = new Banana();
		System.out.println("이름: " + b.name);
	}

}
