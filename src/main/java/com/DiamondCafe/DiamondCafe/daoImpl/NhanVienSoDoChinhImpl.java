package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import com.DiamondCafe.DiamondCafe.model.Khachhang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.KhachHang;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.bean.Order;
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

	@Override
	public int AddOrder(int soBan, int GiamGiaHD, int ID_KhachHang, String ID_NhanVien) {
		// Set bàn đang hoạt động
		String query = "UPDATE BAN SET TrangThai=1 WHERE SoBan=?";
		jdbc.update(query, new Object[] {soBan});
		// Thêm thông tin order vào hóa đơn
		query = "INSERT INTO HOA_DON VALUES(?, ?, ?, ?, ?, ?)";
		String Ca = "";
		if(new Date().getHours()>=6 && new Date().getHours()<=11)
			Ca="Sáng";
		if(new Date().getHours()>=13 && new Date().getHours()<=17)
			Ca="Chiều";
		if(new Date().getHours()>17 && new Date().getHours()<=22)
			Ca="Tối";
		jdbc.update(query, new Object[] {
				soBan
				, new java.sql.Date(new Date().getTime())
				, Ca
				, GiamGiaHD
				, ID_KhachHang
				, ID_NhanVien
		});
		// Lấy mã hóa đơn vừa thêm
		query = "SELECT MAX(SoHD) FROM HOA_DON";
		return jdbc.queryForObject(query, Integer.class);
	}

	@Override
	public void AddOrderDetail(List<Order> list, int ID_HoaDon) {
		String query = "INSERT INTO CT_HOA_DON VALUES(?, ?, ?, ?, ?)";
		for (Order o : list) {
			jdbc.update(query, new Object[] {
					o.getMaMon()
					, o.getSoLuong()
					, o.getDonGia()
					, o.getGhiChu()
					, ID_HoaDon
			});
		}
	}

	@Override
	public void EmptyTable(int SoBan) {
		String query = "UPDATE BAN SET TrangThai=0 WHERE SoBan=?";
		jdbc.update(query, new Object[] {SoBan});
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
		m.setGiaBan(rs.getDouble("GiaBan"));
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
