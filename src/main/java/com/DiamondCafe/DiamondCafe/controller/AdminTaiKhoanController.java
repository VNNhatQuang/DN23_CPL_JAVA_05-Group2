package com.DiamondCafe.DiamondCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;
import com.DiamondCafe.DiamondCafe.service.TaiKhoanAdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminTaiKhoanController {
	
	@Autowired
	private TaiKhoanAdminService tkService;
	
	@GetMapping("login")
	public String login() {
		return "Admin/TaiKhoan/login";
	}
	
	@PostMapping("checklogin")
	public String login(@RequestParam("account") String account, 
	                    @RequestParam("pass") String pass, HttpServletRequest request,
	                    HttpSession session) {
		TaiKhoan tk= tkService.taiKhoan(account, pass);
		if(tk!=null) {
			request.setAttribute("Account", tk);
			session.setAttribute("MaTK", tk.getMaTK());
			session.setAttribute("Pass", tk.getMatKhau());
			return "Admin/TaiKhoan/home-page";
		}else {
			return "redirect:/admin/login";

		}		
	}
	
	@GetMapping("show-info")
	public String showInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("MaTK");
        String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= tkService.taiKhoan(MaTK, Pass);
		request.setAttribute("Account", tk);
		return "Admin/TaiKhoan/show-info";
	}
}
