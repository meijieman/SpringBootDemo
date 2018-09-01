package com.major.elegant.jpa.dao;

import com.major.elegant.bean.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GirlDaoJpa extends JpaRepository<Girl, Integer> {

    List<Girl> getGirlsByName(final String name);

    @Query("select g from Girl g where g.name = ?1")
    List<Girl> findGirlsByName(String name);

}