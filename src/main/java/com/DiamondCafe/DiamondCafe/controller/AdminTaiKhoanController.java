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
		if(account=="" || account ==null || pass=="" || pass==null) {
			return "redirect:/admin/login";
		}else {
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
	}
	
	@GetMapping("home-page")
	public String homePage(HttpServletRequest request,HttpSession session) {
        String MaTK = (String) session.getAttribute("MaTK");
        String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= tkService.taiKhoan(MaTK, Pass);
        
        if(tk!=null) {
        	request.setAttribute("Account", tk);
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
        
        if(tk!=null) {
        	request.setAttribute("Account", tk);
        	return "Admin/TaiKhoan/show-info";
        }else {
        	return "redirect:/admin/login";
        }
	}
	
	@GetMapping("logout")
	public String logout (HttpServletRequest request, HttpSession session) {
		session.removeAttribute("MaTK");
		session.removeAttribute("Pass");
		
		return "redirect:/admin/login";
	}
	
	@GetMapping("change-pass")
	public String changePass (HttpServletRequest request, HttpSession session) {
		String MaTK = (String) session.getAttribute("MaTK");
        String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= tkService.taiKhoan(MaTK, Pass);
        
        if(tk!=null) {
        	request.setAttribute("Account", tk);
        	return "Admin/TaiKhoan/change-pass";
        }else {
        	return "redirect:/admin/login";
        }
	}
	
	@PostMapping("change-pass")
	public String checkUpdate(@RequestParam("oldPass") String oldPass,
								@RequestParam("newPass") String newPass,
								@RequestParam("reNewPass") String reNewPass,
								HttpServletRequest request,
								HttpSession session) {
		String MaTK = (String) session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
		if(MaTK==null) {
			return "redirect:/admin/login";
		}else {
			if(newPass==null || newPass=="" || oldPass==null || oldPass=="" || reNewPass==null || reNewPass==""
					|| !newPass.equals(reNewPass) || !oldPass.equals(Pass)) {
				return "redirect:/admin/change-pass";
			}else {
				tkService.doiMatKhau(MaTK, newPass);
				return "redirect:/admin/login";
			}
		}
	}
	
	@PostMapping("update")
	public String update(HttpServletRequest request, HttpSession session) {
		String MaTK = (String) session.getAttribute("MaTK");
		if(MaTK==null) {
			return "redirect:/admin/login";
		}else {
			String hoten=request.getParameter("hoten");
			String ngaysinh=request.getParameter("ngaysinh");
			String diachi=request.getParameter("diachi");
			String sdt=request.getParameter("sdt");
			String cmt=request.getParameter("cmt");
			if(hoten!=null || hoten!="") {
				tkService.capNhat(MaTK, hoten, ngaysinh, diachi, sdt, cmt);
				return "redirect:/admin/home-page";
			}else {
				return "redirect:/admin/show-info";
			}
		}
	}
}
