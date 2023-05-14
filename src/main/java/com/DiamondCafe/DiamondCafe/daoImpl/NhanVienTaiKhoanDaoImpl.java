package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.NhanVien;
import com.DiamondCafe.DiamondCafe.dao.NhanVienTaiKhoanDao;

@Repository
public class NhanVienTaiKhoanDaoImpl implements NhanVienTaiKhoanDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public NhanVien ktdn(String MaTK, String MatKhau) {
		try {
			String query = "SELECT * FROM NHAN_VIEN WHERE MaTK=? AND MatKhau=?";
			List<NhanVien> tk = jdbc.query(query, new Object[] {
					MaTK
					, MatKhau
			}, new NhanVienRowMapper());
			return tk.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void DoiMatKhau(String MaTK, String MatKhauMoi) {
		String query = "UPDATE NHAN_VIEN SET MatKhau=? WHERE MaTK=?";
		jdbc.update(query, new Object[] {
				MatKhauMoi
				, MaTK
		});
	}
	

}


class NhanVienRowMapper implements RowMapper<NhanVien> {

	@Override
	public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
		NhanVien nv = new NhanVien();
		nv.setMaTK(rs.getString("MaTK"));
		nv.setMatKhau(rs.getString("MatKhau"));
		nv.setTenNV(rs.getString("TenNV"));
		nv.setNgaySinh(rs.getDate("NgaySinh"));
		nv.setDiaChi(rs.getString("DiaChi"));
		nv.setSDT(rs.getString("SDT"));
		nv.setCMT(rs.getString("CMT"));
		nv.setID_ChucVu(rs.getInt("ID_ChucVu"));
		return nv;
	}
	
}

