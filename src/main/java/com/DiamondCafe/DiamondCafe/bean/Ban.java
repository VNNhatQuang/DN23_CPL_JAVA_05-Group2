package com.DiamondCafe.DiamondCafe.bean;

public class Ban {
	private int SoBan;
	private int TrangThai;

	public enum status{
		TRONG,
		DANG_HOAT_DONG,
		DAT_TRUOC
	}
	
	public Ban() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ban(int soBan, int trangThai) {
		super();
		SoBan = soBan;
		TrangThai = trangThai;
	}
	public static status convertTrangthaiNum(int num){
		switch (num) {
			case 0 :
				return status.TRONG;
			case 1:
				return status.DANG_HOAT_DONG;
			case 2:
				return status.DAT_TRUOC;
		}
		return status.TRONG;
	}
	public static int convertTrangthaiName(status TT){
		switch (TT) {
			case TRONG :
				return 0;
			case DAT_TRUOC:
				return 1;
			case DANG_HOAT_DONG:
				return 2;
		}
		return 0 ;
	}
	public int getSoBan() {
		return SoBan;
	}

	public void setSoBan(int soBan) {
		SoBan = soBan;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}
	
	
	
}
