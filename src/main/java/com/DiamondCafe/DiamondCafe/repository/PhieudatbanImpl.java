package com.DiamondCafe.DiamondCafe.repository;

import com.DiamondCafe.DiamondCafe.model.Phieudatban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @CREATED 09/05/2023 - 10:14 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Repository
public class PhieudatbanImpl implements IPhieudatbanRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Phieudatban> getAlllistPhieu() {
        String SQL_ALL = "SELECT * FROM PHIEU_DAT_BAN";
        return jdbcTemplate.query(SQL_ALL, BeanPropertyRowMapper.newInstance(Phieudatban.class)) ;
    }

    @Override
    public List<Phieudatban> getListPhieubyStatus(int status) {
        String SQL_STATUS = "SELECT * FROM PHIEU_DAT_BAN WHERE TRANGTHAI = ? ";
        return  jdbcTemplate.query(SQL_STATUS,
                BeanPropertyRowMapper.newInstance(Phieudatban.class),
                new Object[]{status});
    }

    @Override
    public Phieudatban getPhieubyID(int id) {
        String SQL_ID = "SELECT * FROM PHIEU_DAT_BAN WHERE MAPHIEU = ? ";
        return jdbcTemplate.queryForObject(SQL_ID,
                new BeanPropertyRowMapper<>(Phieudatban.class),
                new Object[]{id});
    }

    @Override
    public int update(Phieudatban pbh) {
        String SQL_UPDATE = "UPDATE PHIEU_DAT_BAN SET TENNGUOIDAT = ? , SODIENTHOAI = ? , NGAYDAT = ? , GIOBATDAU = ? , SO_BAN = ? , TRANGTHAI = ? WHERE MAPHIEU = ?";
        return jdbcTemplate.update(SQL_UPDATE,
                new Object[]{pbh.getTenNguoiDat() , pbh.getSDT() , pbh.getNgayDat() , pbh.getGioBatdau() , pbh.getTrangthai()});
    }

    @Override
    public int save(Phieudatban pbh) {
        String SQL_SAVE= "INSERT INTO PHIEU_DAT_BAN VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL_SAVE,
                new Object[]{pbh.getTenNguoiDat() , pbh.getSDT(), pbh.getNgayDat(), pbh.getGioBatdau(), pbh.getSoBan(), pbh.getTrangthai()});

    }

    @Override
    public int delete(int id) {
        String SQL_DELETE = "DELETE PHIEU_DAT_BAN WHERE MAPHIEU = ?";
        return jdbcTemplate.update(SQL_DELETE, new Object[]{id});
    }
}
