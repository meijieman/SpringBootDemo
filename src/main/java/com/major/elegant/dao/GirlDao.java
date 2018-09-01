package com.major.elegant.dao;

import com.major.elegant.bean.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GirlDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Girl> findGirls(){

        return jdbcTemplate.query("SELECT * FROM girl", new RowMapper<Girl>() {
            @Nullable
            @Override
            public Girl mapRow(ResultSet resultSet, int i) throws SQLException {
                Girl girl = new Girl();
                girl.setId(resultSet.getInt("id"));
                girl.setName(resultSet.getString("name"));
                girl.setAge(resultSet.getInt("age"));
                girl.setBirthday(resultSet.getDate("birthday"));

                return girl;
            }
        });
    }

}
