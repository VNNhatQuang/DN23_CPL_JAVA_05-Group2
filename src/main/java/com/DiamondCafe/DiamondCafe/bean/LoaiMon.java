package com.DiamondCafe.DiamondCafe.bean;

public class LoaiMon {
	private int IDLoai;
	private String TenLoai;
	private int GiamGia;
	
	public LoaiMon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiMon(int iDLoai, String tenLoai, int giamGia) {
		super();
		IDLoai = iDLoai;
		TenLoai = tenLoai;
		GiamGia = giamGia;
	}

	public int getIDLoai() {
		return IDLoai;
	}

	public void setIDLoai(int iDLoai) {
		IDLoai = iDLoai;
	}

	public String getTenLoai() {
		return TenLoai;
	}

	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

	public int getGiamGia() {
		return GiamGia;
	}

	public void setGiamGia(int giamGia) {
		GiamGia = giamGia;
	}

	@Override
	public String toString() {
		return "LoaiMon [IDLoai=" + IDLoai + ", TenLoai=" + TenLoai + ", GiamGia=" + GiamGia + "]";
	}
	
	
	
}
