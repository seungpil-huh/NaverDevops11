package day0325;

// 상속
class AA {
	AA() {
		System.out.println("AA 의 디폴트 생성자");
	}
	
	AA(String msg) {
		System.out.println(msg + "문자열을 받는 생성자 (AA)");
	}
}

class BB extends AA {
	BB() {
		//super(); // 부모 생성자 호출 (생략 되어있음)
		System.out.println("BB 의 디폴트 생성자");
	}
	
	BB(String msg) {
		super(msg); // 생략안됨, 디폴트 생성자인 경우에만 생략 가능
		System.out.println(msg + "를 받는 생성자 (BB)");
	}
}

public class Ex4_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BB b = new BB();
		System.out.println();
		BB b2 = new BB("Hello");
	}

}
