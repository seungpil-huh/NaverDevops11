package day0326;

import java.util.Date;

public class Ex14_Exception {
	
	// 발생하는 예외를 던져서 호출하는 곳에서 처리하도록 한다
	public static void go1() throws NullPointerException, NumberFormatException {
		//Date date = null;
		Date date = new Date();
		System.out.println(date.getYear() + 1900);
		
		//String a = "12a";
		String a = "12";
		int n = Integer.parseInt(a); // 여기서 NumberFormatException
		System.out.println(n + 10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			go1();
		} catch (NullPointerException e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("Date 클래스 생성을 안하고 메소드 호출: " + e.getMessage());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("문자가 있어서 숫자 변환 시 오류 발생: " + e.getMessage());
		} finally {
			System.out.println("이 영역은 무조건 실행됩니다!!");
		}
		
		System.out.println("** 정상 종료 **");
	}

}
