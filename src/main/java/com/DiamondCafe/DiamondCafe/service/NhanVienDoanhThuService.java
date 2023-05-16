package com.DiamondCafe.DiamondCafe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.DoanhThu;
@Service
public interface NhanVienDoanhThuService {
	
	List<DoanhThu> doanhthu();

}