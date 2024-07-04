package mycar.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;

@Repository
@AllArgsConstructor
public class MycarCommentDao {
    private MycarCommentDaoInter commentDaoInter;

    //댓글저장
    public void insertComment(MyCarCommentDto dto)
    {
        commentDaoInter.save(dto);
    }

    //댓글 삭제
    public void deleteComment(int idx)
    {
        commentDaoInter.deleteById(idx);
    }

    //댓글들 반환
    public List<MyCarCommentDto> getAllComments(Long num)
    {
        return commentDaoInter.getMycarCommentList(num);
    }
}
