package com.DiamondCafe.DiamondCafe.dao;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.KhachHang;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.bean.Order;
import com.DiamondCafe.DiamondCafe.model.Khachhang;
import com.DiamondCafe.DiamondCafe.bean.Order;

public interface NhanVienSoDoChinhDao {
	
	List<Ban> getAllTables();
	
	List<LoaiMon> getAllCategories();
	
	List<Mon> getListProduct(int id);
	
	Mon getProduct(int id);

	List<KhachHang> getListCustomer();

	int AddOrder(int soBan, int GiamGiaHD, int ID_KhachHang, String ID_NhanVien);

	void AddOrderDetail(List<Order> list, int ID_HoaDon);

	void EmptyTable(int SoBan);
}
