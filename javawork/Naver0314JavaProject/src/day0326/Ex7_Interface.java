package day0326;

interface StudyInter {
	public void javaStudy();
	public void springStudy();
}

interface PlayInter {
	public void run();
	public void game();
}

class MyStudy implements StudyInter {
	@Override
	public void javaStudy() {
		// TODO Auto-generated method stub
		System.out.println("자바를 공부합니다");
	}
	
	@Override
	public void springStudy() {
		// TODO Auto-generated method stub
		System.out.println("스프링을 공부합니다");
	}
}

class MyPlay implements PlayInter {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("실행");
	}
	
	@Override
	public void game() {
		// TODO Auto-generated method stub
		System.out.println("게임");
	}
}

public class Ex7_Interface {
	
	public static void study(StudyInter s) {
		s.javaStudy();
		s.springStudy();
	}
	
	public static void play(PlayInter p) {
		p.run();
		p.game();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 위의 두 static 메소드를 호출해보세요
		study(new MyStudy());
		play(new MyPlay());
	}

}
