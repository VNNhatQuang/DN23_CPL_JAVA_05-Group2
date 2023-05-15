package com.DiamondCafe.DiamondCafe.service;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.HoaDon;

public interface HoaDonService {
	List<HoaDon> GetHD();
	List<HoaDon> GetCTHD(int SoHD);
}
