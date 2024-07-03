package mycar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mycar.data.MycarDto;

public interface MyCarDaoInter extends JpaRepository<MycarDto, Long> {

}
