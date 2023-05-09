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
		String query = "select * from NHAN_VIEN where MaTK=? and MatKhau=?";
		try {
			TaiKhoan tk = jdbc.queryForObject(query, new Object[] { account, pass }, new TaiKhoanRowMapper());
			return tk;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
}

	@Override
	public void doiMatKhau(String account, String oldPass, String newPass) {

	}

	@Override
	public void chinhSuaThongTinCaNhan(String tenNV, Date ngaySinh, String diaChi, String sDT, String cMT) {
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
				tk.setID_ChucVu(rs.getInt("ID_ChucVu"));

				return tk;
//			}
//			return null;
		}
	}
}
