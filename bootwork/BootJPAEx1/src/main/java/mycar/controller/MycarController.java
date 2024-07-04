package mycar.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import mycar.data.MycarDto;
import mycar.repository.MyCarDao;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
public class MycarController {

    private final MyCarDao myCarDao;
    private final NcpObjectStorageService storageService;

    //bucket 명
    String bucketName="bitcamp-bucket-91";
    //업로드할 폴더명
    String folderName="mycar";

    @GetMapping("/")
    public String home()
    {
        return "redirect:./mycar/list";
    }

//	@GetMapping("/mycar/list")
//	public String list(Model model)
//	{
//		List<MycarDto> list=myCarDao.getAllCars();
//		model.addAttribute("list", list);
//		model.addAttribute("count", list.size());
//		return "mycar/mycarlist";
//	}

    int pageSize;
    @GetMapping("/mycar/list")
    public String list(Model model,
                       @RequestParam(value = "more",defaultValue = "0") int more)
    {
        //more 가 0이면 기본 3개만 출력
        //0 이 아니면 기본사이즈에 more 값을 추가해서 목록을 가져와보자
        if(more==0)
            pageSize=3;
        else
            pageSize+=more;

        //페이징을 위한 Pageable 클래스 처리
        Pageable pageable=PageRequest.of(0, pageSize,Sort.by("num").ascending());
        //페이지에 필요한 만큼 가져오기
        Page<MycarDto> result=myCarDao.getAllCars(pageable);

        model.addAttribute("totalCount", result.getTotalElements());//총갯수
        model.addAttribute("totalPage", result.getTotalPages());//총 페이지수
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("list", result.getContent());

        return "mycar/mycarlist";
    }

    @GetMapping("/mycar/form")
    public String form()
    {
        return "mycar/mycarform";
    }

    @PostMapping("/mycar/insert")
    public String insertCar(@ModelAttribute MycarDto dto,
                            @RequestParam("carupload") MultipartFile carupload
    )
    {
        //사진을 업로드후 업로드된 파일명 반환
        String carphoto=storageService.uploadFile(bucketName, folderName, carupload);
        dto.setCarphoto(carphoto);
        //db insert
        myCarDao.insertCar(dto);

        return "redirect:./list";
    }

    @GetMapping("/mycar/detail")
    public String detail(@RequestParam("num") Long num,Model model)
    {
        MycarDto dto=myCarDao.getData(num);
        model.addAttribute("dto", dto);
        return "mycar/mycardetail";
    }

    //수정폼
    @GetMapping("/mycar/carupdate")
    public String updateForm(@RequestParam("num") Long num,Model model)
    {
        MycarDto dto=myCarDao.getData(num);
        model.addAttribute("dto", dto);
        return "mycar/mycarupdateform";
    }

    //수정
    @PostMapping("/mycar/update")
    public String update(@ModelAttribute("dto") MycarDto dto,
                         @RequestParam("carupload") MultipartFile carupload)
    {
        //수정시 사진선택을 안한경우 carphoto 에 "no"
        if(carupload.getOriginalFilename().equals(""))
            dto.setCarphoto("no");
        else {
            //사진수정을 하기전 스토리지의 기존 사진을 지워보자
            String oldPhotoname=myCarDao.getData(dto.getNum()).getCarphoto();//기존 파일명
            //스토리지에서 삭제
            storageService.deleteFile(bucketName, folderName, oldPhotoname);
            //다시 사진 업로드
            String photo= storageService.uploadFile(bucketName, folderName, carupload);
            dto.setCarphoto(photo);//dto 에 업로드된  파일명 넣기
        }

        //수정 메서드 호출
        myCarDao.updateCar(dto);

        return "redirect:./detail?num="+dto.getNum();//상세보기로 이동
    }

    @GetMapping("/mycar/delete")
    public String delete(@RequestParam("num") Long num)
    {
        //기존 사진명 얻기
        String photoname=myCarDao.getData(num).getCarphoto();
        //스토리지에서 사진 삭제
        storageService.deleteFile(bucketName, folderName, photoname);
        //db 삭제
        myCarDao.deleteCar(num);
        return "redirect:./list";
    }
}
