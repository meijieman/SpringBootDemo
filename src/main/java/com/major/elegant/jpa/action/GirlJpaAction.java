package com.major.elegant.jpa.action;

import com.alibaba.fastjson.JSON;
import com.major.elegant.bean.Girl;
import com.major.elegant.jpa.service.GirlServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class GirlJpaAction {

    @Autowired
    private GirlServiceJpa girlServiceJpa;

    @RequestMapping(value = "/saveGirlJAP", method = RequestMethod.POST)
    public String saveGirl(){
        Girl girl = new Girl();
        girl.setName("jap测试1");
        girl.setAge(26);
        girl.setBirthday(new Date());
        girl = girlServiceJpa.saveGirl(girl);
        if(null != girl && null != girl.getId()){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @RequestMapping(value = "/getGirlByNameJAP", method = RequestMethod.GET)
    public String getGirlByName(){
        List<Girl> girls = girlServiceJpa.getGirlsByName("abc");
        return JSON.toJSONString(girls);
    }

    @RequestMapping(value = "/findGirlByNameJAP", method = RequestMethod.GET)
    public String findGirlByName() {
        List<Girl> girls = girlServiceJpa.findGirlsByName("abc");
        return JSON.toJSONString(girls);
    }

    @RequestMapping(value = "/findGirlsJPA", method = RequestMethod.GET)
    public String findGirls(){
        List<Girl> girls = girlServiceJpa.findGirls();
        return JSON.toJSONString(girls);
    }
}
