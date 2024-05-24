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
	
	// ������- �̸�, �ڵ���, �̸���, �ּ�, ������� �� ���� ��Ÿ������
	@GetMapping("/member/updateform")
	public String updateForm(@RequestParam int num, Model model) {
		// DB �� ���� dto ���
		MemberDto dto = memberService.getData(num);
		model.addAttribute("dto", dto);
		
		return "member/updateform";
	}
	
	// ���� �� detailpage.jsp �� �̵�
}
