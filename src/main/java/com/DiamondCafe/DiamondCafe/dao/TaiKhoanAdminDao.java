package com.DiamondCafe.DiamondCafe.dao;

import java.util.Date;

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;

public interface TaiKhoanAdminDao {
	
	TaiKhoan dangNhap(String account, String pass );
	
	void doiMatKhau(String account, String newPass);
	
	void capNhat(String maTK, String tenNV, String ngaySinh, String diaChi, String sDT, String cMT);
}
