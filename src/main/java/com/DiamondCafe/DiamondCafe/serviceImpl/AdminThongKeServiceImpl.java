package com.DiamondCafe.DiamondCafe.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.ThongKe;
import com.DiamondCafe.DiamondCafe.dao.AdminThongKeDao;
import com.DiamondCafe.DiamondCafe.service.AdminThongKeService;

@Service
public class AdminThongKeServiceImpl implements AdminThongKeService {

	@Autowired
	private AdminThongKeDao tkDao;
	
	@Override
	public ThongKe ThongKeNgay(int day) {
		// TODO Auto-generated method stub
		return tkDao.ThongKeNgay(day);
	}

	@Override
	public ThongKe ThongKeThang(int month) {
		// TODO Auto-generated method stub
		return tkDao.ThongKeThang(month);
	}

}
