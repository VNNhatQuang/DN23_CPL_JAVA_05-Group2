package com.DiamondCafe.DiamondCafe.dao;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;

public interface NhanVienSoDoChinhDao {
	
	List<Ban> getAllTables();
	
	List<LoaiMon> getAllCategories();
	
	List<Mon> getListProduct(int id);
	
}
