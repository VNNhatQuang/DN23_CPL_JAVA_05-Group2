package com.DiamondCafe.DiamondCafe.dao;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.Mon;

public interface MonDao {
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
	
	/**
	 * Lấy 1 món
	 * @param id
	 * @return
	 */
	Mon getMon(int id);
	
	/**
	 * Hàm đếm số record - cho mục đích phân trang
	 * @param searchValue
	 * @return
	 */
	int Count(String searchValue);
}
