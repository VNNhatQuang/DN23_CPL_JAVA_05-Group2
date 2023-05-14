package com.DiamondCafe.DiamondCafe.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DiamondCafe.DiamondCafe.bean.HoaDon;
import com.DiamondCafe.DiamondCafe.dao.HoaDonDao;

@Repository
public class HoaDonDaoImpl implements HoaDonDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<HoaDon> gethd() {
		String query="SELECT SoHD, HoTen, Ngay, sum(CT_HOA_DON.SoLuong * CT_HOA_DON.DonGia) AS TongTien\r\n"
				+ "FROM   HOA_DON INNER JOIN KHACH_HANG ON HOA_DON.ID_KhachHang = KHACH_HANG.MaKH\r\n"
				+ "				INNER JOIN CT_HOA_DON ON HOA_DON.SoHD = CT_HOA_DON.ID_HoaDon\r\n"
				+ "GROUP BY HOA_DON.SoHD, KHACH_HANG.HoTen, HOA_DON.Ngay";
		List<HoaDon> list=jdbc.query(query, new HDRowMapper());
		return list;
	}

	class HDRowMapper implements RowMapper<HoaDon>{
		@Override
		public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
			HoaDon hd=new HoaDon();
			hd.setSoHD(rs.getInt("SoHD"));
			hd.setHoTen(rs.getString("HoTen"));
			hd.setNgay(rs.getDate("Ngay"));
			hd.setTongTien(rs.getDouble("TongTien"));

			return hd;
		}
	}

	@Override
	public List<HoaDon> getcthd(int SoHD) {
		String query="SELECT dbo.NHAN_VIEN.TenNV, dbo.HOA_DON.*, dbo.CT_HOA_DON.SoLuong, dbo.CT_HOA_DON.DonGia, dbo.MON.TenMon, dbo.CT_HOA_DON.GhiChu, dbo.KHACH_HANG.HoTen, \r\n"
				+ "                  dbo.CT_HOA_DON.SoLuong * dbo.CT_HOA_DON.DonGia AS ThanhTien\r\n"
				+ "FROM     dbo.CT_HOA_DON INNER JOIN\r\n"
				+ "                  dbo.HOA_DON ON dbo.CT_HOA_DON.ID_HoaDon = dbo.HOA_DON.SoHD INNER JOIN\r\n"
				+ "                  dbo.KHACH_HANG ON dbo.HOA_DON.ID_KhachHang = dbo.KHACH_HANG.MaKH INNER JOIN\r\n"
				+ "                  dbo.MON ON dbo.CT_HOA_DON.ID_Mon = dbo.MON.MaMon INNER JOIN\r\n"
				+ "                  dbo.NHAN_VIEN ON dbo.HOA_DON.ID_NhanVien = dbo.NHAN_VIEN.MaTK\r\n"
				+ "WHERE SoHD=?";
		List<HoaDon> list=jdbc.query(query, new Object[] {SoHD}, new CTHDRowMapper());
		
		return list;
	}
	
	class CTHDRowMapper implements RowMapper<HoaDon>{
		@Override
		public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
			HoaDon hd=new HoaDon();
			hd.setSoHD(rs.getInt("SoHD"));
			hd.setHoTen(rs.getString("HoTen"));
			hd.setSoBan(rs.getInt("SoBan"));
			hd.setCa(rs.getString("Ca"));
			hd.setID_KhachHang(rs.getInt("ID_KhachHang"));
			hd.setID_NhanVien(rs.getString("ID_NhanVien"));
			hd.setNgay(rs.getDate("Ngay"));
			hd.setSoLuong(rs.getInt("SoLuong"));
			hd.setDonGia(rs.getDouble("DonGia"));
			hd.setTenMon(rs.getString("TenMon"));
			hd.setGhiChu(rs.getString("GhiChu"));
			hd.setTenNV(rs.getString("TenNV"));
			hd.setThanhTien(rs.getDouble("ThanhTien"));

			return hd;
		}
	}
}
