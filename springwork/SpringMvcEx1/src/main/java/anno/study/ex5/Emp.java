package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Emp {
	@NonNull
	private Sawon sawon;
	@Value("���̹�")
	private String empName;
	@Value("2024-03-14")
	private String ipsaday;
	
	public void sawonInfo() {
		// TODO Auto-generated method stub
		System.out.println("** ��� ���� **");
		System.out.println("�Ի���: " + ipsaday);
		System.out.println("ȸ���: " + empName);
		System.out.println("�����: " + sawon.getName());
		System.out.println("�ּ�: " + sawon.getAddr());
		System.out.println("����: " + sawon.getAge());
	}
}
