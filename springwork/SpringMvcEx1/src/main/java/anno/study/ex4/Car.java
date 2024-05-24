package anno.study.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// xml ������� bean ���
//public class Car {
//	private String carName;
//	private Tire tire;
//	
//	public Car(Tire tire) {
//		// TODO Auto-generated constructor stub
//		this.tire = tire;
//	}
//	
//	public void setCarName(String carName) {
//		this.carName = carName;
//	}
//	
//	public void carInfo() {
//		// TODO Auto-generated method stub
//		System.out.println("�ڵ�����: " + carName);
//		System.out.println("Ÿ�̾�: " + tire.getTireName());
//	}
//}

// annotation ���� ����
//@Component	// xml �� car �� ���
//public class Car {
//	@Value("�ƿ��")
//	private String carName;
//	
//	@Autowired	// �ڵ����� ã�Ƽ� ������ ������, �̹����� Tire �� ������ Ŭ������ 2�������� ��ȣ������ ���� ���� �߻�
//	//private Tire tire;
//	private CanadaTire tire; // �� ���� ��Ȯ�ϰ� Ŭ���������� ������ �ؾ߸� ������ �߻����� �ʴ´�
//	
//	public void carInfo() {
//		// TODO Auto-generated method stub
//		System.out.println("�ڵ�����: " + carName);
//		System.out.println("Ÿ�̾�: " + tire.getTireName());
//	}
//}

// �̹����� tire �� lombok �� �̿��ؼ� �����غ���
@Component	// xml �� car �� ���
@RequiredArgsConstructor	// @NonNull �� ���� ��������� �����ڷ� ���Եȴ�
public class Car {
	@Value("�ƿ��")
	private String carName;
	
	@NonNull
	private CanadaTire tire;
	
	public void carInfo() {
		// TODO Auto-generated method stub
		System.out.println("�ڵ�����: " + carName);
		System.out.println("Ÿ�̾�: " + tire.getTireName());
	}
}
