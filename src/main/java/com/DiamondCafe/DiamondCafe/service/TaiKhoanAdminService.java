package com.DiamondCafe.DiamondCafe.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;

@Service
public interface TaiKhoanAdminService {

	TaiKhoan taiKhoan(String account, String pass);
	public void doiMatKhau(String account, String newPass);
	public void capNhat(String maTK, String tenNV, String ngaySinh, String diaChi, String sDT, String cMT);
}
