package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component	// xml�� canadaTire �� ���
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "ĳ����Ÿ�̾�";
	}
	
}
