package com.DiamondCafe.DiamondCafe.bean;

public class Mon {
	private int MaMon;
	private String TenMon;
	private String DonViTinh;
	private double GiaBan;
	private int GiamGia;
	private int ID_LoaiMon;
	
	public Mon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mon(int maMon, String tenMon, String donViTinh, double giaBan, int giamGia, int iD_LoaiMon) {
		super();
		MaMon = maMon;
		TenMon = tenMon;
		DonViTinh = donViTinh;
		GiaBan = giaBan;
		GiamGia = giamGia;
		ID_LoaiMon = iD_LoaiMon;
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

	public String getDonViTinh() {
		return DonViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}

	public double getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}

	public int getGiamGia() {
		return GiamGia;
	}

	public void setGiamGia(int giamGia) {
		GiamGia = giamGia;
	}

	public int getID_LoaiMon() {
		return ID_LoaiMon;
	}

	public void setID_LoaiMon(int iD_LoaiMon) {
		ID_LoaiMon = iD_LoaiMon;
	}
	
	
}
