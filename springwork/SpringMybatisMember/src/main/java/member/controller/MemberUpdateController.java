package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.dto.MemberDto;
import member.service.MemberService;

@Controller
public class MemberUpdateController {
	
	@Autowired
	private MemberService memberService;
	
	// 수정폼- 이름, 핸드폰, 이메일, 주소, 생년월일 만 폼에 나타나도록
	@GetMapping("/member/updateform")
	public String updateForm(@RequestParam int num, Model model) {
		// DB 로 부터 dto 얻기
		MemberDto dto = memberService.getData(num);
		model.addAttribute("dto", dto);
		
		return "member/updateform";
	}
	
	// 수정 후 detailpage.jsp 로 이동
}
