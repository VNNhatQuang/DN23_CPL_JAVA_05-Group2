package com.DiamondCafe.DiamondCafe.bean;

public class Ban {
	private int SoBan;
	private String TrangThai;
	
	public Ban() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ban(int soBan, String trangThai) {
		super();
		SoBan = soBan;
		TrangThai = trangThai;
	}

	public int getSoBan() {
		return SoBan;
	}

	public void setSoBan(int soBan) {
		SoBan = soBan;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	
	
	
}
