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
	
	int AddOrder(int soBan, int GiamGiaHD, int ID_KhachHang, String ID_NhanVien);
	
	void AddOrderDetail(List<Order> list, int ID_HoaDon);
	
	void EmptyTable(int SoBan);
	
	
	List<KhachHang> searchCustomer(String search);
	
	void AddToOrder(Order mon, List<Order> list);
	
	double TotalMoney(List<Order> list);
	
	List<Order> DeleteProductFromOrder(int id, List<Order> list);
}
