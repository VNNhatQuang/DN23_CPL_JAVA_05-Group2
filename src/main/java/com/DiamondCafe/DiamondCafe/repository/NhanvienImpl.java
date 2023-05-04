package repository;

import model.Nhanvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 9:50 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Repository
public class NhanvienImpl implements INhanvienRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Nhanvien> getlistNhanvien() {
        String SQL_ALL = "SELECT * FROM NHAN_VIEN";
        return jdbcTemplate.query(SQL_ALL, BeanPropertyRowMapper.newInstance(Nhanvien.class));
    }

    @Override
    public int save(Nhanvien nv) {
        String SQL_SAVE = "INSERT INTO NHAN_VIEN VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL_SAVE,
                new Object[]{nv.getMatkhau(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), nv.getCMT(), nv.getID_ChucVu()});
    }

    @Override
    public int update(Nhanvien nv) {
        String SQL_SAVE = "UPDATE NHAN_VIEN SET Matkhau = ? , TenNV = ? , Ngaysinh = ? , Diachi = ? , SDT = ? , CMT = ? , ID_Chucvu = ? WHERE MATK = ?";
        return jdbcTemplate.update(SQL_SAVE,
                new Object[]{nv.getMatkhau(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), nv.getCMT(), nv.getID_ChucVu(), nv.getMaTK()});
    }

    @Override
    public int delete(int id) {
        String SQL_DELETE = "DELETE NHAN_VIEN WHERE MATK = ?";
        return jdbcTemplate.update(SQL_DELETE, new Object[]{id});
    }

    @Override
    public Nhanvien getNhanvienbyID(int id) {
        String SQL_GETID = "SELECT * FROM NHAN_VIEN WHERE MATK = ? ";
        return (Nhanvien) jdbcTemplate.query(SQL_GETID,
                new Object[]{id},
                new BeanPropertyRowMapper(Nhanvien.class));
    }
}
