package com.DiamondCafe.DiamondCafe.dao;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.HoaDon;

public interface HoaDonDao {
	List<HoaDon> gethd();
	List<HoaDon> getcthd(int SoHD);
}
