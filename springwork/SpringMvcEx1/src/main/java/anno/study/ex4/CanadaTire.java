package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component	// xml에 canadaTire 로 등록
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "캐나다타이어";
	}
	
}
