package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //����Ʈ ������
@AllArgsConstructor //��� ��������� ���ڷ� �޴� ������
//@Setter
//@Getter
//@ToString
@Data // Setter + Getter + ToString
public class ShopDto {
	private String sang;
	private String photo;
	private int price;
	private int su;
}
