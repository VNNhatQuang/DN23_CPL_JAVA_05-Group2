package com.DiamondCafe.DiamondCafe.bean;

import java.util.Date;

public class HoaDon {
	private int SoHD;
	private int SoBan;
	private Date Ngay;
	private String Ca;
	private int ID_KhachHang;
	private String ID_NhanVien;
	private String TenMon;
	private int SoLuong;
	private double DonGia;
	private String GhiChu;
	private String HoTen;
	private String TenNV;
	private double ThanhTien;
	private double TongTien;
	
	public HoaDon() {
		super();
	}

	public HoaDon(int soHD, int soBan, Date ngay, String ca, int iD_KhachHang, String iD_NhanVien, String tenMon,
			int soLuong, double donGia, String ghiChu, String hoTen, String tenNV, double thanhTien, double tongTien) {
		super();
		SoHD = soHD;
		SoBan = soBan;
		Ngay = ngay;
		Ca = ca;
		ID_KhachHang = iD_KhachHang;
		ID_NhanVien = iD_NhanVien;
		TenMon = tenMon;
		SoLuong = soLuong;
		DonGia = donGia;
		GhiChu = ghiChu;
		HoTen = hoTen;
		TenNV = tenNV;
		ThanhTien = thanhTien;
		TongTien = tongTien;
	}

	public int getSoHD() {
		return SoHD;
	}

	public void setSoHD(int soHD) {
		SoHD = soHD;
	}

	public int getSoBan() {
		return SoBan;
	}

	public void setSoBan(int soBan) {
		SoBan = soBan;
	}

	public Date getNgay() {
		return Ngay;
	}

	public void setNgay(Date ngay) {
		Ngay = ngay;
	}

	public String getCa() {
		return Ca;
	}

	public void setCa(String ca) {
		Ca = ca;
	}

	public int getID_KhachHang() {
		return ID_KhachHang;
	}

	public void setID_KhachHang(int iD_KhachHang) {
		ID_KhachHang = iD_KhachHang;
	}

	public String getID_NhanVien() {
		return ID_NhanVien;
	}

	public void setID_NhanVien(String iD_NhanVien) {
		ID_NhanVien = iD_NhanVien;
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

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public double getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(double thanhTien) {
		ThanhTien = thanhTien;
	}

	public double getTongTien() {
		return TongTien;
	}

	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	
	
	
}
