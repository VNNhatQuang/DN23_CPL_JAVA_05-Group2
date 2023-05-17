package com.DiamondCafe.DiamondCafe.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DiamondCafe.DiamondCafe.bean.ThongKe;
import com.DiamondCafe.DiamondCafe.service.AdminThongKeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/thongke")
public class AdminThongKeController {

	@Autowired
	private AdminThongKeService tkService;


	@GetMapping("ngay")
	public String ThongKeTheoNgay(HttpServletRequest request) {
		List<ThongKe> list = new ArrayList<>();
		int day = new Date().getDate();
		if(request.getParameter("Day")!=null)
			day = Integer.parseInt(request.getParameter("Day"));
		// Lấy 7 ngày kế tiếp của ngày bắt đầu
		Calendar cal = Calendar.getInstance();
		List<Integer> listDate = new ArrayList<>();
		for(int i=new Date().getDate(); i<new Date().getDate()+7; i++) {
			if(i>cal.getActualMaximum(Calendar.DATE))
				break;
			listDate.add(i);
		}
		for(int i=day; i<day+7; i++) {
			if(i>cal.getActualMaximum(Calendar.DATE))
				break;
			ThongKe tk = tkService.ThongKeNgay(i);
			list.add(tk);
		}
		request.setAttribute("listDate", listDate);
		request.setAttribute("list", list);
//		System.err.println("Ngày cuối cùng của tháng hiện tại" + cal.getActualMaximum(Calendar.DATE));
//		System.err.println("Tháng hiện tại" + Calendar.DATE);
		return "Admin/ThongKe/theongay";
	}

	@GetMapping("thang")
	public String ThongKeTheoThang(HttpServletRequest request) {
		List<ThongKe> list = new ArrayList<>();
		int month = new Date().getMonth() + 1;
		System.out.println(month);
		if(request.getParameter("Month")!=null)
			month = Integer.parseInt(request.getParameter("Month"));
		// Lấy 3 tháng kế tiếp của tháng bắt đầu
		Calendar cal = Calendar.getInstance();
		List<Integer> listMonth = new ArrayList<>();
		for(int i=month; i<month+3; i++) {
			if(i>12)
				break;
			listMonth.add(i);
			ThongKe tk = tkService.ThongKeThang(i);
			list.add(tk);
		}
		request.setAttribute("listMonth", listMonth);
		request.setAttribute("list", list);
		return "Admin/ThongKe/theothang";
	}

	@GetMapping("quy")
	public String ThongKeTheoQuy(HttpServletRequest request) {
		List<ThongKe> list = new ArrayList<>();
		// Lấy 4 quý kế tiếp
		int flag = 1;
		for(int q=1; q<=4; q++) {
			int sumMoney = 0;
			for(int m=flag; m<flag+3; m++) {
				sumMoney+=tkService.ThongKeThang(m).getMoney();
			}
			flag+=3;
			list.add(new ThongKe(0, 0, q, sumMoney));
		}
		request.setAttribute("list", list);
		return "Admin/ThongKe/theoquy";
	}

}
