package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.dao.AdminLoaiMonDao;

@Repository
public class AdminLoaiMonDaoImpl implements AdminLoaiMonDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<LoaiMon> getList(int page, int pageSize, String searchValue) {
		String query = "SELECT *\r\n"
				+ "FROM \r\n"
				+ "(\r\n"
				+ "	SELECT	*, ROW_NUMBER() OVER (ORDER BY IDLoai) AS RowNumber\r\n"
				+ "	FROM	LOAI_MON \r\n"
				+ "	WHERE	(? = N'')\r\n"
				+ "		OR	(\r\n"
				+ "				(IDLoai LIKE ?)\r\n"
				+ "				OR (TenLoai LIKE ?)\r\n"
				+ "			)\r\n"
				+ ") AS t\r\n"
				+ "WHERE (? = 0) OR (t.RowNumber BETWEEN (? - 1) * ? + 1 AND ? * ?)";
		List<LoaiMon> list = jdbc.query(query, new Object[] {
				searchValue
				, searchValue
				, searchValue
				, pageSize
				, page
				, pageSize
				, page
				, pageSize
		}, new LoaiMonRowMapper());
		return list;
	}

	@Override
	public void Add(LoaiMon lm) {
		String query = "INSERT INTO LOAI_MON(TenLoai) VALUES(?)";
		jdbc.update(query, new Object[] {
				lm.getTenLoai()
		});
	}

	@Override
	public void Update(LoaiMon lm) {
		String query = "UPDATE LOAI_MON SET TenLoai=? WHERE IDLoai=?";
		jdbc.update(query, new Object[] {
				lm.getTenLoai()
				, lm.getIDLoai()
		});
	}

	@Override
	public void Delete(int id) {
		String query = "DELETE FROM LOAI_MON WHERE IDLoai=?";
		jdbc.update(query, id);
	}
	
	@Override
	public LoaiMon getLoaiMon(int id) {
		String query = "SELECT * FROM LOAI_MON WHERE IDLoai=?";
		LoaiMon lm = jdbc.queryForObject(query, new Object[] {
				id
		}, new LoaiMonRowMapper());
		return lm;
	}
	
	@Override
	public int Count(String searchValue) {
		String query = "SELECT COUNT(*) FROM LOAI_MON "
				+ "WHERE (? LIKE N'') "
				+ "OR (? LIKE IDLoai) "
				+ "OR (? LIKE TenLoai) ";
		int count = jdbc.queryForObject(query, new Object[] {
				searchValue
				, searchValue
				, searchValue
		}, Integer.class);
		return count;
	}
	
	@Override
	public List<LoaiMon> getAll() {
		String query = "SELECT * FROM LOAI_MON";
		List<LoaiMon> list = jdbc.query(query, new LoaiMonRowMapper());
		return list;
	}

}



class LoaiMonRowMapper implements RowMapper<LoaiMon> {

	@Override
	public LoaiMon mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoaiMon lm = new LoaiMon();
		lm.setIDLoai(rs.getInt("IDLoai"));
		lm.setTenLoai(rs.getString("TenLoai"));
		return lm;
	}
	
}