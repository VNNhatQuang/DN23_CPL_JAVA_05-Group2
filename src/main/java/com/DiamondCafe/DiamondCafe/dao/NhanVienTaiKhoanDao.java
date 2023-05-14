package com.DiamondCafe.DiamondCafe.dao;

import com.DiamondCafe.DiamondCafe.bean.NhanVien;

public interface NhanVienTaiKhoanDao {
	
	NhanVien ktdn(String MaTK, String MatKhau);
	
	void DoiMatKhau(String MaTK, String MatKhauMoi);
}