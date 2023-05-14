package com.DiamondCafe.DiamondCafe.dao;

import java.util.List;

import com.DiamondCafe.DiamondCafe.bean.LoaiMon;

public interface AdminLoaiMonDao {
	
	/**
	 * Hàm lấy danh sách Loại món - Tìm kiếm và Phân trang
	 * @param page Trang cần hiển thị
	 * @param pageSize Số dòng trên mỗi trang
	 * @param searchValue Giá trị tìm kiếm
	 * @return
	 */
	List<LoaiMon> getList(int page, int pageSize, String searchValue);
	
	/**
	 * Hàm thêm Loại món
	 * @param lm
	 */
	void Add(LoaiMon lm);
	
	/**
	 * Hàm Cập nhật Loại món
	 * @param lm
	 */
	void Update(LoaiMon lm);
	
	/**
	 * Hàm xóa Loại món
	 * @param id
	 */
	void Delete(int id);
	
	/**
	 * Hàm lấy Loại món bằng id
	 * @param id
	 */
	LoaiMon getLoaiMon(int id);
	
	/**
	 * Hàm đếm số record - cho mục đích phân trang
	 * @param searchValue
	 * @return
	 */
	int Count(String searchValue);
	
	/**
	 * Hàm lấy danh sách tất cả Loại món
	 * @return
	 */
	List<LoaiMon> getAll();
}
