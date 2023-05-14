/*
 * package com.DiamondCafe.DiamondCafe.daoImpl;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.jdbc.core.BeanPropertyRowMapper; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.DiamondCafe.DiamondCafe.bean.Nhanvien; import
 * com.DiamondCafe.DiamondCafe.dao.INhanvienRepository;
 * 
 * import java.util.List;
 * 
 *//**
	 * @CREATED 04/05/2023 - 9:50 AM
	 * @PROJECT Project
	 * @AUTHOR Kiel
	 *//*
		 * @Repository public class NhanvienImpl implements INhanvienRepository{
		 * 
		 * @Autowired private JdbcTemplate jdbcTemplate;
		 * 
		 * @Override public List<Nhanvien> getlistNhanvien() { String SQL_ALL =
		 * "SELECT * FROM NHAN_VIEN"; return jdbcTemplate.query(SQL_ALL,
		 * BeanPropertyRowMapper.newInstance(Nhanvien.class)); }
		 * 
		 * @Override public int save(Nhanvien nv) { String SQL_SAVE =
		 * "INSERT INTO NHAN_VIEN VALUES (?,?,?,?,?,?,?,?)"; return
		 * jdbcTemplate.update(SQL_SAVE, new Object[]{nv.getMaTK(), nv.getMatkhau(),
		 * nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), nv.getCMT(),
		 * nv.getID_ChucVu()}); }
		 * 
		 * @Override public int update(Nhanvien nv) { String SQL_SAVE =
		 * "UPDATE NHAN_VIEN SET Matkhau = ? , TenNV = ? , Ngaysinh = ? , Diachi = ? , SDT = ? , CMT = ? , ID_Chucvu = ? WHERE MATK = ?"
		 * ; return jdbcTemplate.update(SQL_SAVE, new Object[]{nv.getMatkhau(),
		 * nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), nv.getCMT(),
		 * nv.getID_ChucVu(), nv.getMaTK()}); }
		 * 
		 * @Override public int delete(String id) { String SQL_DELETE =
		 * "DELETE NHAN_VIEN WHERE MATK = ?"; return jdbcTemplate.update(SQL_DELETE, new
		 * Object[]{id}); }
		 * 
		 * @Override public Nhanvien getNhanvienbyID(String id) { String SQL_GETID =
		 * "SELECT * FROM NHAN_VIEN WHERE MATK = ? "; return
		 * jdbcTemplate.queryForObject(SQL_GETID, new
		 * BeanPropertyRowMapper<>(Nhanvien.class), new Object[]{id}); } }
		 */