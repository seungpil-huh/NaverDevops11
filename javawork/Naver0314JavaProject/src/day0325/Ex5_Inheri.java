package day0325;

// 같은 패키지 내에서는 부모가 가진 메소드 중 private 을 제외하고 모두 상속받음
class Parent1 {
	void method1() {
		System.out.println("부모의 디폴트 메소드");
	}
	
	protected void method2() {
		System.out.println("부모의 protected 메소드");
	}
	
	private void method3() {
		System.out.println("부모의 private 메소드");
	}
	
	public void method4() {
		System.out.println("부모의 public 메소드");
	}
}

// 서브 클래스 구현
class Sub1 extends Parent1 {
	public void show() {
		/*
		 * 현재 클래스에 같은 이름의 메소드가 존재할 경우
		 * 부모 메소드 호출 시 앞에 super 로 호출
		 * 
		 * 같은 이름의 메소드가 없을 경우 super 대신 this 로 호출해도 된다
		 * 
		 * 부모와 같은 이름의 메소드를 Override Method 라고 한다
		 */
		
		this.method1(); // default, 부모가 다른 패키지에 있다면 default 메소드도 호출 안됨
		this.method2(); // protected
		//this.method3(); // private 메소드는 상속되지 않음
		this.method4(); // public
		System.out.println("super 로 호출");
		super.method1();
		super.method2();
		super.method4();
	}
}

public class Ex5_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub1 s = new Sub1();
		s.show();
	}

}
