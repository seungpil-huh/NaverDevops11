package day0327;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 * 1. 이름추가 2. 이름삭제 3. 이름출력 4. 이름검색 5. 종료
 * 
 * 각 숫자를 입력받아 위 작업을 수행
 * 5. 종료를 누르면 값이 다 날아간다. (파일로 저장해두면 남아있다)
 * 
 * 
 * 종료시 파일에 저장 후
 * 처음 생성시 파일에서 읽어올것
 */
import java.util.*;

public class Ex7_Vector {
	Scanner sc = new Scanner(System.in);
	List<String> list = new Vector<String>();
	//파일 생성
	static final String FILENAME = "C:\\naver0314\\person.txt";
	//파일을 읽어 list에 저장된 이름 추가하기
	public Ex7_Vector() { //personRead의 FileNotFoundException을 받아 try-catch
		try {
			personRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//생성자에서 호출
	public void personRead() throws IOException {
		FileReader fReader = null;
		BufferedReader bReader = null;
		try {
			fReader = new FileReader(FILENAME);
			bReader = new BufferedReader(fReader);
			while(true) {
				String nameString = bReader.readLine();
				if(nameString==null) {
					break;
				}
				//list에 생성자 추가
				list.add(nameString);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("읽어올 명단이 없습니다");
		}finally { //IOException은 throws 로 해결
//			bReader.close(); //fReader = new FileReader(FILENAME)에서 파일이 없으면 그 밑줄의 bReader = new BufferedReader(Reader)이 실행되지 않아서 오류가 난다
//			fReader.close();
			if(bReader!=null)bReader.close(); //bReader가 null이 아닐 때만 종료함으로써 에러 해결
			if(fReader!=null)bReader.close();
		}
		
	}
	//종료시 저장
	public void personSave() {
		FileWriter fWriter = null;
		try {
			fWriter = new FileWriter(FILENAME);
			for(String string:list) {
				fWriter.write(string+"\n");
			}
			System.out.println("총"+list.size()+"명의 명단을 파일에 저장합니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fWriter!=null) { //try 안으로 들어가도 상관없다
				try {
					fWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	//메뉴 선택시 번호 반환
	public int getMenu() { //멤버변수를 쓸거면 static 안해준다
		int menu = 0;
		System.out.println("-".repeat(45));
		System.out.println("1. 이름추가 2. 이름삭제 3. 이름출력 4. 이름검색 5. 종료");
		System.out.println("-".repeat(45));
		menu = Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	public void addPerson() {
		System.out.println("추가할 이름 입력해주세요");
		String nameStrings = sc.nextLine();
		list.add(nameStrings);
		System.out.println(list.size()+"번째 멤버를 추가했어요!");
		
	}
	
	public void deletePerson() {
		System.out.println("삭제할 이름을 입력해주세요");
		String nameString = sc.nextLine();
		boolean f = list.remove(nameString); //입력한 이름을 삭제한다
		if(!f) { //f == false, !f == true
			System.out.println(nameString+"님은 명단에 없습니다");
		} else {
			System.out.println(nameString+"늠을 명단에서 삭제했습니다");
		}
		
	}
	public void listPerson() {
		System.out.println("멤버 현황을 출력합니다");
		for(int i=0;i<list.size(); i++) {
			System.out.println(i+1+"번째 멤버: "+list.get(i));
		}
		
	}
	public void searchPerson() {
		//이름을 입력하면 "강호동님은 2번째에 있습니다" 또는 "강호동님은 멤버명단에 없습니다"
		boolean f = false;
		System.out.println("검색할 이름을 입력해주세요");
		String findNameString = sc.nextLine();
		for(int i=0;i<list.size();i++) {
			String listNameString = list.get(i);
			if(listNameString.equals(findNameString)) {
				f=true;
				System.out.println(findNameString+"님은 "+(i+1)+"번째에 있습니다");
			}
		}
		if(!f) {
			System.out.println(findNameString+"님은 명단에 없습니다");
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7_Vector ex7_Vector = new Ex7_Vector(); //필요하다
		while(true) {
			int menu = ex7_Vector.getMenu();
			if(menu==5) {
				ex7_Vector.personSave();
				System.out.println("** 명단을 파일에 저장후 종료합니다 **");
				break;
			}
			
			switch(menu) {
				case 1: 
					ex7_Vector.addPerson();
					break;
				case 2: 
					ex7_Vector.deletePerson();
					break;
				case 3: 
					ex7_Vector.listPerson();
					break;
			case 4: 
				ex7_Vector.searchPerson();
				break;
			default: 
				System.out.println("***** 번호 입력이 잘못되었어요ㅠㅠㅠ *****");
			}
			System.out.println();
		}
	}

}
