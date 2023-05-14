package com.DiamondCafe.DiamondCafe.bean;

public class KhachHang {
	private int MaKH;
	private String HoTen;
	private String SDT;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int maKH, String hoTen, String sDT) {
		super();
		MaKH = maKH;
		HoTen = hoTen;
		SDT = sDT;
	}

	public int getMaKH() {
		return MaKH;
	}

	public void setMaKH(int maKH) {
		MaKH = maKH;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	
	
}