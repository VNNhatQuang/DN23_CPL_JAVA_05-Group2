package com.DiamondCafe.DiamondCafe.bean;

import java.util.Date;

public class TaiKhoan {
	private String MaTK;
	private String MatKhau;
	private String TenNV;
	private Date NgaySinh;
	private String DiaChi;
	private String SDT;
	private String CMT;
	private String TenChucVu;
	
	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String maTK, String matKhau, String tenNV, Date ngaySinh, String diaChi, String sDT, String cMT,
			String tenChucVu) {
		super();
		MaTK = maTK;
		MatKhau = matKhau;
		TenNV = tenNV;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		SDT = sDT;
		CMT = cMT;
		TenChucVu = tenChucVu;
	}

	public String getMaTK() {
		return MaTK;
	}

	public void setMaTK(String maTK) {
		MaTK = maTK;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getCMT() {
		return CMT;
	}

	public void setCMT(String cMT) {
		CMT = cMT;
	}

	public String getTenChucVu() {
		return TenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		TenChucVu = tenChucVu;
	}
	
	
	
}
