package com.DiamondCafe.DiamondCafe.service;

import java.util.Iterator;
import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.KhachHang;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.bean.Order;

public interface NhanVienSoDoChinhService {

	List<Ban> getAllTables();
	
	List<LoaiMon> getAllCategories();
	
	List<Mon> getListProduct(int id);
	
	Mon getProduct(int id);
	
	List<KhachHang> getListCustomer();
	
	
	
	void AddToOrder(Order mon, List<Order> list);
	
	double TotalMoney(List<Order> list);
	
	List<Order> DeleteProductFromOrder(int id, List<Order> list);
}