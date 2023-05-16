package com.DiamondCafe.DiamondCafe.repository;

import com.DiamondCafe.DiamondCafe.model.Khachhang;
import com.DiamondCafe.DiamondCafe.model.Nhanvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 5:07 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Repository
public class KhachhangImpl implements IKhachhangRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Khachhang> getlistKhachhang() {
        String SQL_ALL = "SELECT * FROM KHACH_HANG";
        return jdbcTemplate.query(SQL_ALL, BeanPropertyRowMapper.newInstance(Khachhang.class));
    }
    // Lúc tạo mới khách hàng thì điểm tích lũy nên = 0
    @Override
    public int save(Khachhang kh) {
        String SQL_SAVE = "INSERT INTO KHACH_HANG VALUES (?,?)";
        return jdbcTemplate.update(SQL_SAVE,
                new Object[]{kh.getHoten(), kh.getSDT()});
    }

    @Override
    public int update(Khachhang kh) {
        String SQL_UPDATE = "UPDATE KHACH_HANG SET HOTEN = ? , SDT = ? WHERE MAKH = ?";
        return jdbcTemplate.update(SQL_UPDATE,
                new Object[]{kh.getHoten(), kh.getSDT() , kh.getMaKH()});
    }

    @Override
    public int delete(int id) {
        String SQL_DELETE = "DELETE KHACH_HANG WHERE MAKH = ?";
        return jdbcTemplate.update(SQL_DELETE, new Object[]{id});
    }

    @Override
    public Khachhang getKhachhangbyID(int id) {
        String SQL_GETID = "SELECT * FROM KHACH_HANG WHERE MAKH = ? ";
        return jdbcTemplate.queryForObject(SQL_GETID,
                new BeanPropertyRowMapper<>(Khachhang.class),
                new Object[]{id});
    }
}
