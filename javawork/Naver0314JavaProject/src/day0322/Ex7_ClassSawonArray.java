package day0322;

import java.util.Scanner;

// Call By Reference
public class Ex7_ClassSawonArray {
	// 입력받는 메소드
	public static void inputSawonArray(Sawon sa[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("총 " + sa.length + " 명의 사원정보를 입력하세요");
		
		for (int i = 0; i < sa.length; i++) {
			System.out.println("사원명은? ");
			String name = sc.nextLine();
			System.out.println("기본급은? ");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.println("수당은? ");
			int sudang = Integer.parseInt(sc.nextLine());
			
			sa[i] = new Sawon();
			sa[i].setSawon(name, gibon, sudang); // 생성을 안하고 호출 시 널포인트 오류가 발생함
			System.out.println();
		}
	}
	
	// 출력하는 메소드
	public static void outputSawonArray(Sawon sa[]) {
		System.out.println("\t\t[사원 급여 현황]\n");
		System.out.println("번호\t사원명\t기본급\t수당\t실수령액");
		System.out.println("=".repeat(60));
		
		for (int i = 0; i < sa.length; i++) {
			System.out.println((i + 1) + "\t" + sa[i].getName() + "\t" + sa[i].getGibon() 
					+ "\t" + sa[i].getSudang() + "\t" + sa[i].getNetPay());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon sawon[] = null;
		int inwon;
		Scanner sc = new Scanner(System.in);
		System.out.println("직원 인원수는? ");
		inwon = Integer.parseInt(sc.nextLine());
		// 인원 수 만큼 메모리 할당
		sawon = new Sawon[inwon]; // 인원 수 만큼 객체 할당, 초기값은 null
		
		inputSawonArray(sawon);
		outputSawonArray(sawon);
	}

}
