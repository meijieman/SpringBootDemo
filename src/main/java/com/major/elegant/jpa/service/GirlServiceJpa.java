package com.major.elegant.jpa.service;

import com.major.elegant.bean.Girl;
import com.major.elegant.jpa.dao.GirlDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlServiceJpa {

    @Autowired
    private GirlDaoJpa girlDaoJpa;

    public Girl saveGirl(Girl girl){
        return  girlDaoJpa.save(girl);
    }

    public List<Girl> getGirlsByName(String name){
        return girlDaoJpa.getGirlsByName(name);
    }

    public List<Girl> findGirlsByName(String name){
        return girlDaoJpa.findGirlsByName(name);
    }

    public List<Girl> findGirls(){
        return girlDaoJpa.findAll();
    }
}
