package com.DiamondCafe.DiamondCafe.serviceImpl;

import java.util.Date;

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

	@Override
	public void doiMatKhau(String account, String newPass) {
		// TODO Auto-generated method stub
		taiKhoanDao.doiMatKhau(account, newPass);
	}

	@Override
	public void capNhat(String maTK, String tenNV, String ngaySinh, String diaChi, String sDT, String cMT) {
		// TODO Auto-generated method stub
		taiKhoanDao.capNhat(maTK, tenNV, ngaySinh, diaChi, sDT, cMT);
	}
	
}