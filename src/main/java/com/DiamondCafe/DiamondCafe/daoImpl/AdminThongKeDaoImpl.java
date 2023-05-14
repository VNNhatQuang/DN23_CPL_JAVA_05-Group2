package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.ThongKe;
import com.DiamondCafe.DiamondCafe.dao.AdminThongKeDao;

@Repository
public class AdminThongKeDaoImpl implements AdminThongKeDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public ThongKe ThongKeNgay(int day) {
		String query = "SELECT DAY(Ngay) as Ngay, SUM(SoLuong*DonGia) as TongTien "
				+ "FROM HOA_DON hd join CT_HOA_DON cthd ON hd.SoHD=cthd.ID_HoaDon "
				+ "WHERE DAY(Ngay) = ? "
				+ "GROUP BY DAY(Ngay)";
		List<ThongKe> list = jdbc.query(query, new Object[] {
				day
		}, new ThongKeRowMapper());
		if(list.isEmpty())
			return new ThongKe(day, 0, 0, 0);
		return list.get(0);
	}

	@Override
	public ThongKe ThongKeThang(int month) {
		String query = "SELECT MONTH(Ngay) as Thang, SUM(SoLuong*DonGia) as TongTien "
				+ "FROM HOA_DON hd join CT_HOA_DON cthd ON hd.SoHD=cthd.ID_HoaDon "
				+ "WHERE MONTH(Ngay) = ? "
				+ "GROUP BY MONTH(Ngay)";
		List<ThongKe> list = jdbc.query(query, new Object[] {
				month
		}, new ThongKeRowMapper());
		if(list.isEmpty())
			return new ThongKe(0, month, 0, 0);
		return list.get(0);
	}

}


class ThongKeRowMapper implements RowMapper<ThongKe> {

	@Override
	public ThongKe mapRow(ResultSet rs, int rowNum) throws SQLException {
		ThongKe tk = new ThongKe();
		tk.setDay(rs.getInt(1));
		tk.setMonth(rs.getInt(1));
		tk.setQuarter(rs.getInt(1));
		tk.setMoney(rs.getDouble(2));
		return tk;
	}
	
}