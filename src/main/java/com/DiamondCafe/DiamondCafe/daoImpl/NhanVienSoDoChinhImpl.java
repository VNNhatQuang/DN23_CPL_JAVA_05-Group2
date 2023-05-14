package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.KhachHang;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.dao.NhanVienSoDoChinhDao;

@Repository
public class NhanVienSoDoChinhImpl implements NhanVienSoDoChinhDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<Ban> getAllTables() {
		String query = "SELECT * FROM BAN";
		return jdbc.query(query, new BanRowMapper());
	}

	@Override
	public List<LoaiMon> getAllCategories() {
		String query = "SELECT * FROM LOAI_MON";
		return jdbc.query(query, new LoaiMonRowMapper());
	}

	@Override
	public List<Mon> getListProduct(int id) {
		String query = "SELECT * FROM MON WHERE ID_LoaiMon=?";
		return jdbc.query(query, new Object[] {
			id
		}, new MonRowMapper());
	}

	@Override
	public Mon getProduct(int id) {
		String query = "SELECT * FROM MON WHERE MaMon=?";
		List<Mon> list = jdbc.query(query, new Object[] {
				id
		}, new MonRowMapper());
		return list.get(0);
	}

	@Override
	public List<KhachHang> getListCustomer() {
		String query = "SELECT * FROM KHACH_HANG WHERE MaKH>1";
		return jdbc.query(query, new KhachHangRowMapper());
	}

}


class BanRowMapper implements RowMapper<Ban> {

	@Override
	public Ban mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ban b = new Ban();
		b.setSoBan(rs.getInt("SoBan"));
		b.setTrangThai(rs.getInt("TrangThai"));
		return b;
	}
	
}

class MonRowMapper implements RowMapper<Mon> {

	@Override
	public Mon mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mon m = new Mon();
		m.setMaMon(rs.getInt("MaMon"));
		m.setTenMon(rs.getString("TenMon"));
		m.setDonViTinh(rs.getString("DonViTinh"));
		m.setGiaBan(rs.getFloat("GiaBan"));
		m.setID_LoaiMon(rs.getInt("ID_LoaiMon"));
		return m;
	}
	
}

class KhachHangRowMapper implements RowMapper<KhachHang> {

	@Override
	public KhachHang mapRow(ResultSet rs, int rowNum) throws SQLException {
		KhachHang kh = new KhachHang();
		kh.setMaKH(rs.getInt("MaKH"));
		kh.setHoTen(rs.getString("HoTen"));
		kh.setSDT(rs.getString("SDT"));
		return kh;
	}
	
}