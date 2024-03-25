package day0325;
// 교재 328 페이지 예제 해보기
// 단 Animal, Dog, Cat 은 이미 구현되어 있으므로
// Animal2, Dog2, Cat2 로 구현하세요
// 추상 클래스에 대한 예제임. 내일 주로 이 내용으로 예제 할거예요

public class Ex11_Book328 {
	public static void animalSound(Animal2 animal) {
		animal.sound();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog2 dog = new Dog2();
		dog.sound();
		
		Cat2 cat = new Cat2();
		cat.sound();
		
		// 매개변수의 다형성
		animalSound(new Dog2());
		animalSound(new Cat2());
	}

}
