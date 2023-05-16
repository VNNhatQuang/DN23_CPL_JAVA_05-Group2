package com.DiamondCafe.DiamondCafe.bean;

public class DoanhThu {
	private int SoHD;
	private String TenNV;
	private int SoLuong;
	private float DonGia;
	private double ThanhTien;
	public DoanhThu() {
		super();
	}
	public DoanhThu(int soHD, String tenNV, int soLuong, float donGia, double thanhTien) {
		super();
		SoHD = soHD;
		TenNV = tenNV;
		SoLuong = soLuong;
		DonGia = donGia;
		ThanhTien = thanhTien;
	}
	public int getSoHD() {
		return SoHD;
	}
	public void setSoHD(int soHD) {
		SoHD = soHD;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	public double getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(double thanhTien) {
		ThanhTien = thanhTien;
	}
	
	
	
	

}