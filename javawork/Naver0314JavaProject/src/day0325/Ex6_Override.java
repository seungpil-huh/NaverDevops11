package day0325;

class Parent2 {
	public void job() {
		System.out.println("부모클래스에서 해야할 일 처리...");
	}
}

class Sub2 extends Parent2 {

	@Override
	public void job() {
		// TODO Auto-generated method stub
		System.out.println("자식클래스에서 해야할 일 처리...");
		super.job(); // 같은 이름의 메소드가 현재 클래스에 존재(오버라이드)하므로 부모가 가진 메소드 호출 시 반드시 super.메소드명()으로 호출
	}
	
}

public class Ex6_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub2 s = new Sub2();
		s.job(); // Sub2 가 가진 job() 메소드 호출
	}

}
