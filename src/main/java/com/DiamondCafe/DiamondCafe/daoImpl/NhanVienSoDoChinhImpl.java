package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.Ban;
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
		m.setGiamGia(rs.getInt("GiamGia"));
		m.setID_LoaiMon(rs.getInt("ID_LoaiMon"));
		return m;
	}
	
}
