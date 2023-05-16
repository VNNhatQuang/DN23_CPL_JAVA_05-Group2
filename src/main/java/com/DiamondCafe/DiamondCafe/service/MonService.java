package com.DiamondCafe.DiamondCafe.service;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.Mon;

public interface MonService {
	/**
	 * Hàm lấy danh sách món - Tìm kiếm và Phân trang
	 * @param page Trang cần hiển thị
	 * @param pageSize Số dòng trên mỗi trang
	 * @param searchValue Giá trị tìm kiếm
	 * @return
	 */
	List<Mon> GetList(int page, int pageSize, String searchValue);
	
	/**
	 * Hàm lấy danh sách món
	 * @return
	 */
	List<Mon> GetAllMon();
	
	/**
	 * Hamg thêm món
	 * @param m
	 */
	void CreateMon(Mon m);
	
	/**
	 * Hàm cập nhật món
	 * @param m
	 */
	void UpdateMon(Mon m);
	
	
	/**
	 * Hàm xóa món
	 * @param maMon
	 */
	void DeleteMon(int maMon);
	
	Mon getMon(int id);
	
	int Count(String searchValue);
}
