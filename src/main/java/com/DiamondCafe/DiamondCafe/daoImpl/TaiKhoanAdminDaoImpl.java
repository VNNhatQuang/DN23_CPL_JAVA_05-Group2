package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;
import com.DiamondCafe.DiamondCafe.dao.TaiKhoanAdminDao;

@Repository
public class TaiKhoanAdminDaoImpl implements TaiKhoanAdminDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public TaiKhoan dangNhap(String account, String pass) {
		String query = "select * from NHAN_VIEN, CHUC_VU where NHAN_VIEN.ID_ChucVu=CHUC_VU.MaChucVu and MaTK=? and MatKhau=? and ID_ChucVu =1 ";
		try {
			TaiKhoan tk = jdbc.queryForObject(query, new Object[] { account, pass }, new TaiKhoanRowMapper());
//			jdbc.update(query);
			return tk;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public void doiMatKhau(String account, String newPass) {
		String query = "update NHAN_VIEN set MatKhau=? where MaTK=?";
		jdbc.update(query, new Object[] {newPass, account});
	}

	@Override
	public void capNhat(String maTK, String tenNV, String ngaySinh, String diaChi, String sDT, String cMT) {
		String query = "update NHAN_VIEN set TenNV=?, NgaySinh=?, DiaChi=?, SDT=?, CMT=? where MaTK=?";
		jdbc.update(query, new Object[] {tenNV, ngaySinh, diaChi, sDT, cMT, maTK});
	}

	class TaiKhoanRowMapper implements RowMapper<TaiKhoan> {

		@Override
		public TaiKhoan mapRow(ResultSet rs, int rowNum) throws SQLException {
//			if (rs.next()) {
			TaiKhoan tk = new TaiKhoan();
			tk.setMaTK(rs.getString("MaTK"));
			tk.setMatKhau(rs.getString("MatKhau"));
			tk.setTenNV(rs.getString("TenNV"));
			tk.setNgaySinh(rs.getDate("NgaySinh"));
			tk.setDiaChi(rs.getString("DiaChi"));
			tk.setSDT(rs.getString("SDT"));
			tk.setCMT(rs.getString("CMT"));
			tk.setTenChucVu(rs.getString("TenChucVu"));

			return tk;
//			}
//			return null;
		}
	}
}