package com.DiamondCafe.DiamondCafe.bean;

public class Mon {
	private int MaMon;
	private String TenMon;
	private String TenLoai;
	private int ID_LoaiMon;
	private String DonViTinh;
	private float GiaBan;
	private int GiamGia;
	
	
	public Mon(int maMon, String tenMon, String tenLoai, String donViTinh, float giaBan, int giamGia, int iD_LoaiMon) {
		super();
		MaMon = maMon;
		TenMon = tenMon;
		TenLoai = tenLoai;
		DonViTinh = donViTinh;
		GiaBan = giaBan;
		GiamGia = giamGia;
		ID_LoaiMon = iD_LoaiMon;
	}

	public Mon() {
		super();
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

	public String getTenLoai() {
		return TenLoai;
	}

	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

	public String getDonViTinh() {
		return DonViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}

	public float getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(float giaBan) {
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
