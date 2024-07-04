package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mycar_comment")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //오류날경우 추가,불필요한 직렬화를 막기위한 어노테이션
public class MyCarCommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    /* *
     * 은행 서비스에서 사용자(TABLE_USER)가 1개 이상의 계좌(TABLE_ACCOUNT)를
     * 가질수 있다고 가정할경우 TABLE_USER 입장에서 보면 OneToMany이고,
     * TABLE_ACCOUNT 입장에서 보면 ManyToOne이다.
     */

    @ManyToOne
    @JoinColumn(name = "num")
    @OnDelete(action = OnDeleteAction.CASCADE)//부모테이블의 데이타를 지우면 댓글은 자동삭제
    private MycarDto mycar;

    @Column(length = 200) //아예 생략시 255가 된다
    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    @Column(updatable = false)//수정시 제외컬럼
    @CreationTimestamp //엔터티가 생성되는 시점의 시간이 자동등록
    private Timestamp writeday;
}
