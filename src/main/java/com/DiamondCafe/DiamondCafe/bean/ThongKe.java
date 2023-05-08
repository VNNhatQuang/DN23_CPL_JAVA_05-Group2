package com.DiamondCafe.DiamondCafe.bean;

public class ThongKe {
	private int Day;
	private int Month;
	private int Quarter;
	private double Money;
	
	public ThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThongKe(int day, int month, int quarter, double money) {
		super();
		Day = day;
		Month = month;
		Quarter = quarter;
		Money = money;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getQuarter() {
		return Quarter;
	}

	public void setQuarter(int quarter) {
		Quarter = quarter;
	}

	public double getMoney() {
		return Money;
	}

	public void setMoney(double money) {
		Money = money;
	}

	
	
	
}
