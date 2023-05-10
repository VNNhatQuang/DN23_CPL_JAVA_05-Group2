package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.Ban;
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

}


class BanRowMapper implements RowMapper<Ban> {

	@Override
	public Ban mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ban b = new Ban();
		b.setSoBan(rs.getInt("SoBan"));
		b.setTrangThai(rs.getString("TrangThai"));
		return b;
	}
	
}
