package day0520.uploadcontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadMultiController {
	@GetMapping("/uploadform2")
	public String upload2() {
		return "upload/uploadform2";
	}
	
	@PostMapping("/upload2")
	public String uploadResult(
			@RequestParam String title,
			@RequestParam("upload") List<MultipartFile> upload,
			HttpServletRequest request,
			Model model
			) {
		// 톰캣 서버에 배포된 프로젝트에서 이미지가 업로드될 경로 구하기
		String realFolder = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realFolder); // 콘솔로 출력 후 탐색기를 열어서 이미지를 확인해주세요
		
		// 총 사진 개수를 모델에 저장을 해두자
		int len = upload.size();
		model.addAttribute("len", len);
		model.addAttribute("title", title);
		
		// 여러장의 사진을 서버에 업로드 해보자
		// 저장되는 네임은 photo1, photo2,...
		List<String> photolist = new Vector<>();
		
		for (MultipartFile multi : upload) {
			// 업로드될 파일명 구하기
			String photo = UUID.randomUUID() + ".jpg";
			
			try {
				multi.transferTo(new File(realFolder + "/" + photo));
				
				// 업로드 성공 시 모델에 파일명을 저장
				photolist.add(photo);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("photolist", photolist);
		
		return "upload/resultphoto2";
	}
}
