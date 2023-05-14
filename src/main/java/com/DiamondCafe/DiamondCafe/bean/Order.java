package com.DiamondCafe.DiamondCafe.bean;

public class Order {
	private int MaMon;
	private String TenMon;
	private int SoLuong;
	private double DonGia;
	private String GhiChu;
	private double ThanhTien;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int maMon, String tenMon, int soLuong, double donGia, String ghiChu) {
		super();
		MaMon = maMon;
		TenMon = tenMon;
		SoLuong = soLuong;
		DonGia = donGia;
		GhiChu = ghiChu;
		ThanhTien = SoLuong * DonGia;
	}

	public int getMaMon() {
		return MaMon;
	}

	public void setMaMon(int maMon) {
		MaMon = maMon;
	}

	public String getTenMon() {
		return TenMon;
	}

	public void setTenMon(String tenMon) {
		TenMon = tenMon;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		DonGia = donGia;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public double getThanhTien() {
		return SoLuong*DonGia;
	}

	public void setThanhTien(double thanhTien) {
		ThanhTien = thanhTien;
	}

	
	
	
	
}