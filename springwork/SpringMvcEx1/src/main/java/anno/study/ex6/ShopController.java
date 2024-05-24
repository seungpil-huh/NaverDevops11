package anno.study.ex6;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("shopcont")
@AllArgsConstructor	// 만약 멤버변수가 dao 외에 많다면 @RequiredArgsConstructor 를 하는게 좋다
public class ShopController {
	ShopDao dao;
	
	public void insert(String sang, int su, int dan) {
		ShopDto dto = new ShopDto(sang, su, dan);
		dao.insert(dto);
		
		dao.selectAll();
	}
	
	public void delete(String sang) {
		dao.delete(sang);
		
		dao.selectAll();
	}
	
	public void update(String sang, int su, int dan) {
		ShopDto dto = new ShopDto();
		dto.setSang(sang);
		dto.setSu(su);
		dto.setDan(dan);
		dao.update(dto);
		
		dao.selectAll();
	}
}
