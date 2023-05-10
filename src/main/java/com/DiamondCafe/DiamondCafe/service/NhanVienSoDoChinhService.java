package com.DiamondCafe.DiamondCafe.service;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;

public interface NhanVienSoDoChinhService {

	List<Ban> getAllTables();
	
	List<LoaiMon> getAllCategories();
	
	List<Mon> getListProduct(int id);
	
}
