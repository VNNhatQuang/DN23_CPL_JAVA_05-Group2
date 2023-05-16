/*
 * package com.DiamondCafe.DiamondCafe.daoImpl;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.jdbc.core.BeanPropertyRowMapper; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.DiamondCafe.DiamondCafe.bean.KhachHang; import
 * com.DiamondCafe.DiamondCafe.dao.IKhachhangRepository;
 * 
 * import java.util.List;
 * 
 *//**
	 * @CREATED 04/05/2023 - 5:07 PM
	 * @PROJECT Project
	 * @AUTHOR Kiel
	 *//*
		 * @Repository public class KhachhangImpl implements IKhachhangRepository {
		 * 
		 * @Autowired private JdbcTemplate jdbcTemplate;
		 * 
		 * @Override public List<KhachHang> getlistKhachhang() { String SQL_ALL =
		 * "SELECT * FROM KHACH_HANG"; return jdbcTemplate.query(SQL_ALL,
		 * BeanPropertyRowMapper.newInstance(KhachHang.class)); } // Lúc tạo mới khách
		 * hàng thì điểm tích lũy nên = 0
		 * 
		 * @Override public int save(KhachHang kh) { String SQL_SAVE =
		 * "INSERT INTO KHACH_HANG VALUES (?,?,?)"; return jdbcTemplate.update(SQL_SAVE,
		 * new Object[]{kh.getHoten(), kh.getSDT(), kh.getDiemTichLuy()}); }
		 * 
		 * @Override public int update(KhachHang kh) { String SQL_SAVE =
		 * "UPDATE KHACH_HANG SET HOTEN = ? , SDT = ? , DIEMTICHLUY = ? WHERE MAKH = ?";
		 * return jdbcTemplate.update(SQL_SAVE, new Object[]{kh.getHoten(), kh.getSDT(),
		 * kh.getDiemTichLuy() , kh.getMaKH()}); }
		 * 
		 * @Override public int delete(int id) { String SQL_DELETE =
		 * "DELETE KHACH_HANG WHERE MAKH = ?"; return jdbcTemplate.update(SQL_DELETE,
		 * new Object[]{id}); }
		 * 
		 * @Override public KhachHang getKhachhangbyID(int id) { String SQL_GETID =
		 * "SELECT * FROM KHACH_HANG WHERE MAKH = ? "; return
		 * jdbcTemplate.queryForObject(SQL_GETID, new
		 * BeanPropertyRowMapper<>(KhachHang.class), new Object[]{id}); } }
		 */