package com.DiamondCafe.DiamondCafe.service;

import com.DiamondCafe.DiamondCafe.bean.NhanVien;

public interface NhanVienTaiKhoanService {

	NhanVien ktdn(String MaTK, String MatKhau);

	void DoiMatKhau(String MaTK, String MatKhauMoi);

}