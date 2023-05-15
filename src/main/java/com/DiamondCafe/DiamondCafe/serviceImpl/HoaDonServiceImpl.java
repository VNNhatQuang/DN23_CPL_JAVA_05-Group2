package com.DiamondCafe.DiamondCafe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.HoaDon;
import com.DiamondCafe.DiamondCafe.dao.HoaDonDao;
import com.DiamondCafe.DiamondCafe.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService{

	@Autowired
	private HoaDonDao hdDao;
	
	@Override
	public List<HoaDon> GetHD() {
		return hdDao.gethd();
	}

	@Override
	public List<HoaDon> GetCTHD(int SoHD) {
		// TODO Auto-generated method stub
		return hdDao.getcthd(SoHD);
	}

}
