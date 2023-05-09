package com.DiamondCafe.DiamondCafe.service;

import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;

@Service
public interface TaiKhoanAdminService {

	TaiKhoan taiKhoan(String account, String pass);
}
