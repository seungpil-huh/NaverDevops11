package day0320;

import java.util.Scanner;

public class Ex12_ArrayMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 처음에 인원수(inwon) 를 입력받은 후 해당 인원수 만큼
		 * name,kor,eng,tot,rank 변수를 배열 할당하고
		 * 인원수만큼 이름,국어점수,영어점수를 입력하면
		 * 총점과 등수를 계산하여 출력하는 프로그램을 작성하시오
		 * 
		 * 출력은
		 * -------------------------------------
		 * 번호	 이름   국어   영어   총점   등수
		 * -------------------------------------
		 * 	1   강호동   90   100   190    1
		 *  2   이영자  100    70   170    3
		 *  3   유재석   90    90   180    2
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원수를 입력하세요: ");
		int inwon = Integer.parseInt(sc.nextLine());
		
		String[] name = new String[inwon];
		int[] kor = new int[inwon];
		int[] eng = new int[inwon];
		int[] tot = new int[inwon];
		int[] rank = new int[inwon];
		
		// 사용자 입력 받기
        for (int i = 0; i < inwon; i++) {
            System.out.println((i + 1) + "번 학생의 이름, 국어 점수, 영어 점수를 입력하세요:");
            name[i] = sc.nextLine();
            kor[i] = Integer.parseInt(sc.nextLine());
            eng[i] = Integer.parseInt(sc.nextLine());
            tot[i] = kor[i] + eng[i];
            rank[i] = 1; // 초기 등수 설정
        }

        // 등수 계산
        for (int i = 0; i < inwon; i++) {
            for (int j = 0; j < inwon; j++) {
                if (tot[i] < tot[j]) {
                    rank[i]++;
                }
            }
        }

        // 결과 출력
        System.out.println("-".repeat(50));
        System.out.println("번호\t이름\t국어\t영어\t총점\t등수");
        System.out.println("-".repeat(50));
        for (int i = 0; i < inwon; i++) {
            System.out.println((i + 1) + "\t" + name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + tot[i] + "\t" + rank[i]);
        }
	}

}
