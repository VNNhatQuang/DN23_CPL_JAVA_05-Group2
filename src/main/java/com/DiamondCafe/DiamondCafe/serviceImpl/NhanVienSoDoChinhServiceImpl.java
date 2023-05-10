package com.DiamondCafe.DiamondCafe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.dao.NhanVienSoDoChinhDao;
import com.DiamondCafe.DiamondCafe.service.NhanVienSoDoChinhService;

@Service
public class NhanVienSoDoChinhServiceImpl implements NhanVienSoDoChinhService {

	@Autowired
	private NhanVienSoDoChinhDao sdcDao;
	
	@Override
	public List<Ban> getAllTables() {
		// TODO Auto-generated method stub
		return sdcDao.getAllTables();
	}

	@Override
	public List<LoaiMon> getAllCategories() {
		// TODO Auto-generated method stub
		return sdcDao.getAllCategories();
	}

	@Override
	public List<Mon> getListProduct(int id) {
		// TODO Auto-generated method stub
		return sdcDao.getListProduct(id);
	}

	
	
}
