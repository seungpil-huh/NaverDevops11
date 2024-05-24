package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Sawon {
	@Value("허승필")
	private String name;
	@Value("제주특별자치도 제주시 도남동")
	private String addr;
	@Value("30")
	private int age;
	private String ipsaday;
}
