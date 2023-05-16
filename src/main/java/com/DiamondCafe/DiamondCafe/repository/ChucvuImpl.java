package com.DiamondCafe.DiamondCafe.repository;

import com.DiamondCafe.DiamondCafe.model.Chucvu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @CREATED 16/05/2023 - 3:13 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Repository
public class ChucvuImpl implements IChucvuRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Chucvu> getAllChucvu() {
        String SQL_ALL = "SELECT * FROM CHUC_VU";
        return jdbcTemplate.query(SQL_ALL,
                BeanPropertyRowMapper.newInstance(Chucvu.class));
    }
}
