package bit.mycar.service;

import bit.mycar.data.MycarDto;
import bit.mycar.repository.MyCarDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyCarService {

    private MyCarDao myCarDao;

    public List<MycarDto> getAllDatas() {
        return myCarDao.getAllDatas();
    }
}
