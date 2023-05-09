package com.DiamondCafe.DiamondCafe.dao;

import java.util.Date;

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;

public interface TaiKhoanAdminDao {
	
	TaiKhoan dangNhap(String account, String pass );
	
	void doiMatKhau(String account, String oldPass, String newPass);
	
	void chinhSuaThongTinCaNhan(String tenNV, Date ngaySinh, String diaChi, String sDT, String cMT);
}
