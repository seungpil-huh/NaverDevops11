package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component	//koreaTire �� ���̵� �ȴ�
public class KoreaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "�ѱ�Ÿ�̾�";
	}
	
}
