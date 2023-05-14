package com.DiamondCafe.DiamondCafe.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.NhanVien;
import com.DiamondCafe.DiamondCafe.dao.NhanVienTaiKhoanDao;
import com.DiamondCafe.DiamondCafe.service.NhanVienTaiKhoanService;

@Service
public class NhanVienTaiKhoanServiceImpl implements NhanVienTaiKhoanService {

	@Autowired
	NhanVienTaiKhoanDao tkDao;
	
	@Override
	public NhanVien ktdn(String MaTK, String MatKhau) {
		// TODO Auto-generated method stub
		return tkDao.ktdn(MaTK, MatKhau);
	}

	@Override
	public void DoiMatKhau(String MaTK, String MatKhauMoi) {
		// TODO Auto-generated method stub
		tkDao.DoiMatKhau(MaTK, MatKhauMoi);
	}

}