package com.DiamondCafe.DiamondCafe.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiamondCafe.DiamondCafe.bean.Ban;
import com.DiamondCafe.DiamondCafe.bean.KhachHang;
import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.bean.Order;
import com.DiamondCafe.DiamondCafe.dao.NhanVienSoDoChinhDao;
import com.DiamondCafe.DiamondCafe.service.NhanVienSoDoChinhService;

@Service
public class NhanVienSoDoChinhServiceImpl implements NhanVienSoDoChinhService {

	@Autowired
	private NhanVienSoDoChinhDao sdcDao;
	
	@Override
	public List<Ban> getAllTables() {
		// TODO Auto-generated method stub
		return sdcDao.getAllTables();
	}

	@Override
	public List<LoaiMon> getAllCategories() {
		// TODO Auto-generated method stub
		return sdcDao.getAllCategories();
	}

	@Override
	public List<Mon> getListProduct(int id) {
		// TODO Auto-generated method stub
		return sdcDao.getListProduct(id);
	}

	@Override
	public Mon getProduct(int id) {
		// TODO Auto-generated method stub
		return sdcDao.getProduct(id);
	}

	@Override
	public void AddToOrder(Order mon, List<Order> list)	{	   
		for(Order o : list)
			if(o.getMaMon() == mon.getMaMon()) {
				o.setSoLuong(o.getSoLuong()+1);
				return;
			}
		list.add(mon);
	}

	@Override
	public double TotalMoney(List<Order> list) {
		double sum = 0;
		for (Order o : list)
			sum+=o.getThanhTien();
		return sum;
	}

	@Override
	public List<KhachHang> getListCustomer() {
		// TODO Auto-generated method stub
		return sdcDao.getListCustomer();
	}

	@Override
	public List<Order> DeleteProductFromOrder(int id, List<Order> list) {
		int length = list.size();
		for(int i=length-1; i>=0; i--) {
			if(list.get(i).getMaMon()==id) {
				list.remove(i);
			}
		}
		return list;
	}
	
}