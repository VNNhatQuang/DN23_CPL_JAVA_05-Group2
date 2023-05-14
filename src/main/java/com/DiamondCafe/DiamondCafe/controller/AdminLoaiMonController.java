package com.DiamondCafe.DiamondCafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Paging;
import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;
import com.DiamondCafe.DiamondCafe.service.AdminLoaiMonService;
import com.DiamondCafe.DiamondCafe.service.TaiKhoanAdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/loaimon")
public class AdminLoaiMonController {
	
	@Autowired
	private AdminLoaiMonService lmService;
	private final int PAGE_SIZE = 5;
	@Autowired
	private TaiKhoanAdminService taiKhoanSV;
	
	@GetMapping
	public String Index(HttpServletRequest request, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}
		else {
			request.setAttribute("Account", tk);
			int page = 1;
			if(request.getParameter("page")!=null)
				page = Integer.parseInt(request.getParameter("page"));
			String searchValue = "";
			if(request.getParameter("searchValue")!=null)
				searchValue = request.getParameter("searchValue");
			int rowCount = lmService.Count(searchValue);
			Paging p = new Paging(page, PAGE_SIZE, rowCount, searchValue);
			request.setAttribute("paging", p);
			request.setAttribute("list", lmService.getList(page, PAGE_SIZE, searchValue));
			return "Admin/LoaiMon/index";
		}
	}
	
	@GetMapping("create")
	public String showFormCreate(HttpServletRequest request, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}
		else {
			request.setAttribute("Account", tk);
			return "Admin/LoaiMon/create";
		}
	}
	
	@PostMapping("add")
	public String Add(HttpServletRequest request, @ModelAttribute LoaiMon loaimon) {
		lmService.Add(loaimon);
		return "redirect:/admin/loaimon";
	}
	
	@GetMapping("edit/{id}")
	public String showFormEdit(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}
		else {
			request.setAttribute("Account", tk);
			LoaiMon lm = lmService.getLoaiMon(id);
			request.setAttribute("lm", lm);
			return "Admin/LoaiMon/edit";
		}
	}
	
	@PostMapping("update")
	public String Update(HttpServletRequest request, @ModelAttribute LoaiMon loaimon) {
		lmService.Update(loaimon);
		return "redirect:/admin/loaimon";
	}
	
	@GetMapping("delete/{id}")
	public String showFormDelete(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}
		else {
			request.setAttribute("Account", tk);
			request.setAttribute("lm", lmService.getLoaiMon(id));
			return "Admin/LoaiMon/delete";
		}
	}
	
	@GetMapping("delete/confirm/{id}")
	public String Delete(HttpServletRequest request, @PathVariable("id") int id) {
		lmService.Delete(id);
		return "redirect:/admin/loaimon";
	}
	
}