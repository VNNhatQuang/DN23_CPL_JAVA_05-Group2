package com.DiamondCafe.DiamondCafe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.DoanhThu;
import com.DiamondCafe.DiamondCafe.bean.ThongKe;
import com.DiamondCafe.DiamondCafe.dao.AdminThongKeDao;
import com.DiamondCafe.DiamondCafe.dao.NhanVienDoanhThu;
import com.DiamondCafe.DiamondCafe.service.NhanVienDoanhThuService;
@Service
public class NhanVienDoanhThuServiceImpl implements NhanVienDoanhThuService{

	
	@Autowired
	private NhanVienDoanhThu dtDao;
	
	@Override
	public List<DoanhThu> doanhthu() {
		return dtDao.doanhthu();
	}
	
	
	

}