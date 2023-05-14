package com.DiamondCafe.DiamondCafe.dao;

import com.DiamondCafe.DiamondCafe.bean.ThongKe;

public interface AdminThongKeDao {
	
	ThongKe ThongKeNgay(int day);
	
	ThongKe ThongKeThang(int month);
	
//	ThongKe ThongKeQuy(int quarter);
	
}
