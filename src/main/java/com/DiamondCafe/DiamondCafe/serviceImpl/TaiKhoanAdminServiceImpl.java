package com.DiamondCafe.DiamondCafe.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;
import com.DiamondCafe.DiamondCafe.dao.TaiKhoanAdminDao;
import com.DiamondCafe.DiamondCafe.service.TaiKhoanAdminService;

@Service
public class TaiKhoanAdminServiceImpl implements TaiKhoanAdminService{
	
	@Autowired
	private TaiKhoanAdminDao taiKhoanDao;
	
	@Override
	public TaiKhoan taiKhoan(String account, String pass) {
		
		return taiKhoanDao.dangNhap(account, pass);
	}
	
}