package bit.mycar.controller;

import bit.mycar.data.MycarDto;
import bit.mycar.service.MyCarService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MyCarListController {

    final MyCarService myCarService;
    final NcpObjectStorageService storageService;

    private String bucketName = "bitcamp-bucket-91";
    private String folderName = "mycar";

    private String uploadPhotoname;

    @GetMapping("/mycar/list")
    public List<MycarDto> list() {
        return myCarService.getAllDatas();
    }

    @PostMapping("/mycar/upload")
    public Map<String, String> uploadPhoto(@RequestParam("upload")MultipartFile upload) {
        System.out.println("photo upload >> " + upload.getOriginalFilename());
        // 스토리지에 업로드 후 업로드된 파일명 변환
        String carphoto = storageService.uploadFile(bucketName, folderName, upload);
        Map<String, String> map = new HashMap<>();
        map.put("carphoto", carphoto);

        return map;
    }

    // dto 데이터 db 저장 (json -> dto)
    @PostMapping("/mycar/insert")
    public void insert(@RequestBody MycarDto dto) {
        System.out.println("insert dto >> " + dto); // toString 호출
        myCarService.insertMycar(dto);
    }

    @DeleteMapping("/mycar/delete")
    public void delete(@RequestParam("num") Long num) {
        System.out.println("delete num >> " + num);
        // DB 삭제전에 스토리지의 사진부터 먼저 삭제
        String oldPhotoname = myCarService.getData(num).getCarphoto();
        storageService.deleteFile(bucketName, folderName, oldPhotoname);

        // DB 삭제
        myCarService.deleteMycar(num);
    }
}
