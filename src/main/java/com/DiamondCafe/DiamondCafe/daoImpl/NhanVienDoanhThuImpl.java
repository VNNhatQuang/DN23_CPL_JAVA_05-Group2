package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.DoanhThu;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.ThongKe;
import com.DiamondCafe.DiamondCafe.dao.NhanVienDoanhThu;
@Repository
public class NhanVienDoanhThuImpl implements NhanVienDoanhThu{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<DoanhThu> doanhthu() {
		String query = "SELECT SoHD, TenNV, SUM(CT_HOA_DON.SoLuong * CT_HOA_DON.DonGia) as ThanhTien "
				+ "FROM HOA_DON, NHAN_VIEN, CT_HOA_DON "
				+ "WHERE NHAN_VIEN.MaTK = HOA_DON.ID_NhanVien and HOA_DON.SoHD = CT_HOA_DON.ID_HoaDon "
				+ "GROUP BY HOA_DON.SoHD, NHAN_VIEN.TenNV";
		List<DoanhThu> list = jdbc.query(query, new DoanhThuRowMapper());
		return list;
	}

}

class DoanhThuRowMapper implements RowMapper<DoanhThu> {

	@Override
	public DoanhThu mapRow(ResultSet rs, int rowNum) throws SQLException {
		DoanhThu dt = new DoanhThu();
		dt.setSoHD(rs.getInt("SoHD"));
		dt.setTenNV(rs.getString("TenNV"));
		dt.setThanhTien(rs.getDouble("ThanhTien"));
		return dt;
	}
	
}