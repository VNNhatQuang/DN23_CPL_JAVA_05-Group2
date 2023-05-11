package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.dao.MonDao;

@Repository
public class MonDaoImpl implements MonDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<Mon> GetList(int page, int pageSize, String searchValue) {
		String query = "SELECT *\r\n"
				+ "FROM \r\n"
				+ "(\r\n"
				+ "	SELECT	MON.*, LOAI_MON.TenLoai, ROW_NUMBER() OVER (ORDER BY MaMon) AS RowNumber\r\n"
				+ "	FROM	MON \r\n"
				+ "    INNER JOIN LOAI_MON ON MON.ID_LoaiMon=LOAI_MON.IDLoai \r\n"
				+ "	WHERE	(? = N'')\r\n"
				+ "		OR	(\r\n"
				+ "				(MaMon LIKE ?)\r\n"
				+ "				OR (TenMon LIKE ?)\r\n"
				+ "			)\r\n"
				+ ") AS t\r\n"
				+ "WHERE (? = 0) OR (t.RowNumber BETWEEN (? - 1) * ? + 1 AND ? * ?)";
		List<Mon> list = jdbc.query(query, new Object[] {
				searchValue
				, searchValue
				, searchValue
				, pageSize
				, page
				, pageSize
				, page
				, pageSize
		}, new MonRowMapper());
		return list;
	}

	@Override
	public List<Mon> GetAllMon() {
		// TODO Auto-generated method stub4
		String query="select * from MON, LOAI_MON where MON.ID_LoaiMon=LOAI_MON.IDLoai";
		List<Mon> list=jdbc.query(query, new MonRowMapper());
		
		return list;
	}

	@Override
	public void CreateMon(Mon m) {
		// TODO Auto-generated method stub
		String query="insert into Mon(TenMon, DonViTinh, GiaBan, ID_LoaiMon) values(?,?,?,?)";
		jdbc.update(query, new Object[] {
			m.getTenMon(),
			m.getDonViTinh(),
			m.getGiaBan(),
			m.getID_LoaiMon(),
		});
	}

	@Override
	public void UpdateMon(Mon m) {
		// TODO Auto-generated method stub
		String query = "UPDATE MON SET TenMon=?, DonViTinh=?, GiaBan=?, ID_LoaiMon=? WHERE MaMon=?";
		jdbc.update(query, new Object[] {
				m.getTenMon()
				, m.getDonViTinh()
				, m.getGiaBan()
				, m.getID_LoaiMon()
				, m.getMaMon()
		});
	}

	@Override
	public void DeleteMon(int maMon) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM MON WHERE MaMon=?";
		jdbc.update(query, maMon);
	}
	
	class MonRowMapper implements RowMapper<Mon>{
		@Override
		public Mon mapRow(ResultSet rs, int rowNum) throws SQLException {
			Mon m=new Mon();
			m.setMaMon(rs.getInt("MaMon"));
			m.setTenMon(rs.getString("TenMon"));
			m.setTenLoai(rs.getString("TenLoai"));
			m.setDonViTinh(rs.getString("DonViTinh"));
			m.setGiaBan(rs.getFloat("GiaBan"));
			m.setID_LoaiMon(rs.getInt("ID_LoaiMon"));
			
			return m;
		}
	}

	@Override
	public Mon getMon(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM MON, LOAI_MON WHERE MaMon=? and LOAI_MON.IDLoai=MON.ID_LoaiMon";
		Mon m = jdbc.queryForObject(query, new Object[] {
				id
		}, new MonRowMapper());
		return m;
	}

	@Override
	public int Count(String searchValue) {
		String query = "SELECT COUNT(*) FROM MON "
				+ "WHERE (? LIKE N'') "
				+ "OR (? LIKE MaMon) "
				+ "OR (? LIKE TenMon) ";
		int count = jdbc.queryForObject(query, new Object[] {
				searchValue
				, searchValue
				, searchValue
		}, Integer.class);
		return count;
	}
}
