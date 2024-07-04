package mycar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MycarDto;
import mycar.repository.MycarCommentDao;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mycar")
public class MycarCommentController {
    final private MycarCommentDao commentDao;

    @GetMapping("/addcomment")
    public void addComment(@RequestParam("num") Long num,
                           @RequestParam("comment") String comment)
    {
        //먼저 MyCarDto 에 num 값을 넣은후 MyCarCommentDto 에 넣는다(외부키로 지정된값)
        MycarDto dto=MycarDto.builder().num(num).build();

        MyCarCommentDto commentDto=MyCarCommentDto.builder()
                .comment(comment)
                .mycar(dto)
                .build();
        //댓글 추가
        commentDao.insertComment(commentDto);
    }

    @GetMapping("/commentlist")
    public List<MyCarCommentDto> commentList(@RequestParam("num") Long num)
    {
        return commentDao.getAllComments(num);
    }

}
