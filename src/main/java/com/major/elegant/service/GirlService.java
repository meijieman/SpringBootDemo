package com.major.elegant.service;

import com.major.elegant.bean.Girl;
import com.major.elegant.dao.GirlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
     @Service 用于标注业务层组件、
     @Controller 用于标注控制层组件（如struts中的action）、
     @Repository 用于标注数据访问组件，即DAO组件、
     @Component 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 */
@Service
public class GirlService {

    @Autowired
    private GirlDao girlDao;

    public List<Girl> findGirls(){
        List<Girl> girls = girlDao.findGirls();
        return girls;
    }
}
