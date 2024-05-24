package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // final �̳� NonNull �� ���� ��������� ������ ����
@Setter
public class Student {
	private String schoolName;
	@NonNull
	MyInfo myInfo;
	
//	// MyInfo ������ ������ ����
//	public Student(MyInfo info) {
//		// TODO Auto-generated constructor stub
//		myInfo = info;
//	}
//	
//	// �б����� setter ����
//	public void setSchoolName(String schoolName) {
//		this.schoolName = schoolName;
//	}
	
	public void show() {
		// TODO Auto-generated method stub
		System.out.println(myInfo); // toString ȣ��
		System.out.println("�б���: " + schoolName);
	}
}
