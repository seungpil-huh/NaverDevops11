package day0327;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

/*
 * 	1. 학생 정보 추가: 이름, 나이, 3과목 점수 입력
 * 	2. 학생 정보 삭제: 이름으로 찾아서 삭제 (없을 경우 메세지 출력)
 * 	3. 전체 출력: 번호, 이름, Java, Spring, HTML, 총점, 평균, 등급 출력
 * 	4. 평균으로 검색: 평균값을 입력하면 그 평균값 이상의 학생들을 출력
 * 	5. 이름으로 검색: 입력한 이름을 포함하고 있으면 출력(contains)
 * 	6. 저장 후 종료
 */

public class Ex9_VectorMunje {
	
	static final String FILENAME = "C:\\naver0314\\student.txt";
	List<StudentDto> list = new Vector<StudentDto>();
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() {
		int menu = 0;
		
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 정보 삭제");
		System.out.println("3. 전체 학생 정보 출력");
		System.out.println("4. 평균으로 검색 (평균값을 입력하면 그 평균값 이상의 학생들을 출력)");
		System.out.println("5. 이름으로 검색: 입력한 이름을 포함하고 있으면 출력");
		System.out.println("6. 저장 후 종료");
		System.out.println("=".repeat(50));
		
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			// 만약 문자가 입력되면 무조건 전체 출력을 해보자!
			menu = 3;
		}
		
		return menu;
	}
	
	// 생성자
	public Ex9_VectorMunje() {
		studentReadFile(); // 처음 생성 시 무조건 파일 읽어서 list 에 담기
	}
	
	// 파일 읽어오기
	public void studentReadFile() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while (true) {
				// 한줄 단위로 읽기
				String line = br.readLine();
				if (line == null) {
					break;
				}
				// , 단위로 분리 (배열 형태로 분리)
				String data[] = line.split(",");
				// StudentDto 생성 후 setter 로 데이터 넣기 또는 생성자 통해서 넣기도 됨
				StudentDto dto = new StudentDto();
				dto.setName(data[0]);
				dto.setAge(Integer.parseInt(data[1]));
				dto.setJava(Integer.parseInt(data[2]));
				dto.setSpring(Integer.parseInt(data[3]));
				dto.setHtml(Integer.parseInt(data[4]));
				
				// list 에 추가
				list.add(dto);
			}
			System.out.println("총 " + list.size() + "명의 학생 정보를 읽어왔습니다!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("읽어올 학생 정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e2) {
				// TODO: handle exception
			}
		}
	}
	
	// 저장 후 종료 메소드
	public void studentFileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for (StudentDto dto : list) {
				String s = dto.getName() + "," + dto.getAge() + "," + dto.getJava() + ","
						+ dto.getSpring() + "," + dto.getHtml() + "\n";
				fw.write(s);
			}
			System.out.println("총 " + list.size() + "명의 학생 정보를 파일에 저장 하였습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException|NullPointerException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	// 학생 정보 추가 메소드
	public void addStudent() {
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("나이를 입력하세요");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Java 점수를 입력하세요");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("Spring 점수를 입력하세요");
		int spring = Integer.parseInt(sc.nextLine());
		System.out.println("HTML 점수를 입력하세요");
		int html = Integer.parseInt(sc.nextLine());
		
		// StudentDto 생성후 list 에 추가
		StudentDto dto = new StudentDto(name, age, java, spring, html);
		list.add(dto);
		System.out.println(list.size() + "번째 학생 정보를 추가 하였습니다!");
	}
	
	// 학생 정보 삭제 메소드
	public void deleteStudent() {
		System.out.println("삭제할 이름을 입력해주세요");
		String name = sc.nextLine();
		boolean f = false;
		
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			if (dto.getName().equals(name)) {
				f = true;
				list.remove(i);
				break;
			}
		}
		
		if (f) {
			System.out.println(name + "님의 정보를 삭제하였습니다");
		} else {
			System.out.println(name + "님은 명단에 없습니다");
		}
	}
	
	// 전체 학생 정보 출력 메소드
	public void writeStudent() {
		System.out.println("\t\t ** 전체 학생 정보 출력 **\n");
		System.out.println("=".repeat(70));
		System.out.println("번호\t이름\t나이\tJava\tSpring\tHTML\t총점\t평균\t등급");
		System.out.println("=".repeat(70));
		//평균은 소수점 한자리로 출력해보자
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			System.out.println((i+1) + "\t" + dto.getName() + "\t" + dto.getAge() + "\t"
				    + dto.getJava() + "\t" + dto.getSpring() + "\t" + dto.getHtml() + "\t"
				    + dto.getTotal() + "\t" + nf.format(dto.getAvg()) + "\t" + dto.getGrade());
		}
		System.out.println("=".repeat(70));
	}
	
	// 평균 검색 메소드
	public void searchAverage() {
		// 입력하는 평균값 이상의 학생 정보만 출력하기
		System.out.println("검색할 평균값은?");
		double avg = Double.parseDouble(sc.nextLine());
		
		System.out.printf("\t\t ** %5.1f 평균이상의 학생정보 출력 **\n", avg);
		System.out.println("=".repeat(70));
		System.out.println("번호\t이름\t나이\tJava\tSpring\tHTML\t총점\t평균\t등급");
		System.out.println("=".repeat(70));
		//평균은 소수점 한자리로 출력해보자
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			if (dto.getAvg() >= avg) {
				System.out.println((i + 1) + "\t" + dto.getName() + "\t" + dto.getAge() + "\t" + dto.getJava() + "\t"
						+ dto.getSpring() + "\t" + dto.getHtml() + "\t" + dto.getTotal() + "\t"
						+ nf.format(dto.getAvg()) + "\t" + dto.getGrade());
			}
		}
		System.out.println("=".repeat(70));
	}
	
	// 이름 검색 메소드
	public void searchName() {
		// 입력하는 이름을 포함한 학생 정보만 출력하기
				System.out.println("검색할 이름은?");
				String name = sc.nextLine();
				
				System.out.printf("\t\t ** %5.1f 평균이상의 학생정보 출력 **\n", name);
				System.out.println("=".repeat(70));
				System.out.println("번호\t이름\t나이\tJava\tSpring\tHTML\t총점\t평균\t등급");
				System.out.println("=".repeat(70));
				//평균은 소수점 한자리로 출력해보자
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(1);
				
				for (int i = 0; i < list.size(); i++) {
					StudentDto dto = list.get(i);
					System.out.println((i + 1) + "\t" + dto.getName() + "\t" + dto.getAge() + "\t" + dto.getJava() + "\t"
							+ dto.getSpring() + "\t" + dto.getHtml() + "\t" + dto.getTotal() + "\t"
							+ nf.format(dto.getAvg()) + "\t" + dto.getGrade());
				}
				System.out.println("=".repeat(70));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("컴퓨터".contains("컴")); // true
//		System.out.println("컴퓨터".contains("하")); // false
		
		Ex9_VectorMunje ex = new Ex9_VectorMunje();
		
		while (true) {
			int menu = ex.getMenu();
			
			switch (menu) {
			case 1:
				ex.addStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.writeStudent();
				break;
			case 4:
				ex.searchAverage();
				break;
			case 5:
				ex.searchName();
				break;
			case 6:
				ex.studentFileSave();
				System.out.println("학생 정보를 저장 후 저장합니다");
				System.exit(0);
			default:
				System.out.println("잘못된 번호입니다");
			}
			System.out.println();
		}
	}

}
