package com.DiamondCafe.DiamondCafe.bean;

public class LoaiMon {
	private int IDLoai;
	private String TenLoai;
	
	public LoaiMon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiMon(int iDLoai, String tenLoai) {
		super();
		IDLoai = iDLoai;
		TenLoai = tenLoai;
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
	
}