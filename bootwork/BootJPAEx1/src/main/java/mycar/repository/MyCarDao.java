package mycar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MycarDto;

@Repository
@AllArgsConstructor
public class MyCarDao{

    private MyCarDaoInter daoInter;

    //db 저장
    public void insertCar(MycarDto dto)
    {
        daoInter.save(dto);//id타입(num)이 포함되어있을경우 자동으로 update 실행,없을경우 자동으로 insert 실행
    }

    //전체목록
    public List<MycarDto> getAllCars()
    {
        //return daoInter.findAll(); //추가된 순서로 반환
        //return daoInter.findAll(Sort.by(Sort.Direction.DESC,"carprice"));//가격이 비싼거부터 출력
        //return daoInter.findAll(Sort.by(Sort.Direction.ASC,"carname"));//자동차명의 오름차순
        return daoInter.findAll(Sort.by(Sort.Direction.DESC,"num"));//num 의 내림차순
    }

    public MycarDto getData(Long num)
    {
        return daoInter.getReferenceById(num);
    }

    public void updateCar(MycarDto dto)
    {
        if(dto.getCarphoto().equals("no"))
            daoInter.updateMycarNoPhoto(dto.getNum(), dto.getCarname(),
                    dto.getCarprice(),dto.getCarcolor());

//			daoInter.updateMycarNoPhoto(dto);
        else
            daoInter.save(dto);//num 이 포함되어있을경우 모든 컬럼 수정
    }

    public void deleteCar(Long  num)
    {
        daoInter.deleteById(num);
    }

    //전체 갯수 구하기
    public Long getTotalCount()
    {
        return daoInter.count();
    }

    //페이지 출력
    public Page<MycarDto> getAllCars(Pageable pageable)
    {
        return daoInter.findAll(pageable);//페이지에 필요한만큼만 데이타 반환
    }
}
