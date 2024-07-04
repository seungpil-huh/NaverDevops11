package mycar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import mycar.data.MyCarCommentDto;

public interface MycarCommentDaoInter extends JpaRepository<MyCarCommentDto,Integer>{

    //num 에 해당하는 모든 댓글반환
    @Query(value = "select * from mycar_comment where num=:num order by idx desc"
            ,nativeQuery = true)
    public List<MyCarCommentDto> getMycarCommentList(@Param("num") Long num);
}
