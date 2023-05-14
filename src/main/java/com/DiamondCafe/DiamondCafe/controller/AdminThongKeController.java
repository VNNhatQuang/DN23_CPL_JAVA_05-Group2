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

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;
import com.DiamondCafe.DiamondCafe.bean.ThongKe;
import com.DiamondCafe.DiamondCafe.service.AdminThongKeService;
import com.DiamondCafe.DiamondCafe.service.TaiKhoanAdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/thongke")
public class AdminThongKeController {
	
	@Autowired
	private AdminThongKeService tkService;
	@Autowired
	private TaiKhoanAdminService taiKhoanSV;
	
	
	@GetMapping("ngay")
	public String ThongKeTheoNgay(HttpServletRequest request, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tkh= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tkh==null) {
			return "redirect:/admin/login";
		}else {
			request.setAttribute("Account", tkh);
			List<ThongKe> list = new ArrayList<>();
			int day = new Date().getDay();
			if(request.getParameter("Day")!=null)
				day = Integer.parseInt(request.getParameter("Day"));
			// Lấy 7 ngày kế tiếp của ngày bắt đầu
			Calendar cal = Calendar.getInstance();
			for(int i=day; i<day+7; i++) {
				if(i>cal.getActualMaximum(Calendar.DATE))
					break;
				ThongKe tk = tkService.ThongKeNgay(i);
				list.add(tk);
			}
			request.setAttribute("list", list);
	//		System.err.println("Ngày cuối cùng của tháng hiện tại" + cal.getActualMaximum(Calendar.DATE));
	//		System.err.println("Tháng hiện tại" + Calendar.DATE);
			return "Admin/ThongKe/theongay";
		}
	}
	
	@GetMapping("thang")
	public String ThongKeTheoThang(HttpServletRequest request, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tkh= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tkh==null) {
			return "redirect:/admin/login";
		}else {
			request.setAttribute("Account", tkh);
			List<ThongKe> list = new ArrayList<>();
			int month = new Date().getMonth();
			if(request.getParameter("Month")!=null)
				month = Integer.parseInt(request.getParameter("Month"));
			// Lấy 3 tháng kế tiếp của tháng bắt đầu
			Calendar cal = Calendar.getInstance();
			for(int i=month; i<month+3; i++) {
				if(i>12)
					break;
				ThongKe tk = tkService.ThongKeThang(i);
				list.add(tk);
			}
			request.setAttribute("list", list);
			return "Admin/ThongKe/theothang";
		}
	}
	
	@GetMapping("quy")
	public String ThongKeTheoQuy(HttpServletRequest request, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tkh= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tkh==null) {
			return "redirect:/admin/login";
		}else {
			request.setAttribute("Account", tkh);
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
}
