package anno.study.ex4;

import org.springframework.stereotype.Component;

//@Component	// xml �� �ڵ���� ���ش�, �� ���� Ŭ�����̸��� �� ���̵� �ȴ� (��, ù���ڴ� �ҹ��ڷ� ����)
@Component("h")
public class Hello {
	public void showMessage() {
		System.out.println("Hello class �� ���� �޼ҵ��Դϴ�");
	}
}
