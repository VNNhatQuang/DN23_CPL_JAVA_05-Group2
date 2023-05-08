package com.DiamondCafe.DiamondCafe.dao;

import com.DiamondCafe.DiamondCafe.bean.ThongKe;

public interface ThongKeDao {
	
	ThongKe ThongKeNgay(int day);
	
	ThongKe ThongKeThang(int month);
	
//	ThongKe ThongKeQuy(int quarter);
	
}
