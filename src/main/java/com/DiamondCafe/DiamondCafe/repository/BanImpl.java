package com.DiamondCafe.DiamondCafe.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @CREATED 13/05/2023 - 3:15 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Repository
public class BanImpl  implements IBanRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert() {
        String SQL_INSERT = "INSERT INTO BAN VALUES (0)";
        return jdbcTemplate.update(SQL_INSERT);
    }

    @Override
    public int updateTrangthai(int soBan, int trangthai) {
        String SQL_UPDATE = "UPDATE BAN SET TRANGTHAI = ? WHERE SOBAN = ?";
        return jdbcTemplate.update(SQL_UPDATE,
                new Object[]{trangthai , soBan});
    }

    @Override
    public int delete(int soBan) {
        String SQL_DELETE = "DELETE FROM BAN WHERE SOBAN = ?";
        return jdbcTemplate.update(SQL_DELETE,
                new Object[]{soBan});
    }
}
