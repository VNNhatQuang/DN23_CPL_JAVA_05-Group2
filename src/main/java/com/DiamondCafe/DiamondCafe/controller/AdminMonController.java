package com.DiamondCafe.DiamondCafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DiamondCafe.DiamondCafe.bean.LoaiMon;
import com.DiamondCafe.DiamondCafe.bean.Mon;
import com.DiamondCafe.DiamondCafe.bean.Paging;
import com.DiamondCafe.DiamondCafe.bean.TaiKhoan;
import com.DiamondCafe.DiamondCafe.service.AdminLoaiMonService;
import com.DiamondCafe.DiamondCafe.service.MonService;
import com.DiamondCafe.DiamondCafe.service.TaiKhoanAdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/mon")
public class AdminMonController {
	
	@Autowired
	private MonService monSV;
	@Autowired
	private TaiKhoanAdminService taiKhoanSV;
	@Autowired
	private AdminLoaiMonService loaiMonSV;
	private final int PAGE_SIZE = 5;
	
	
	@GetMapping("list")
	public String index(ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}
		else {
			
			int page = 1;
			if(request.getParameter("page")!=null)
				page = Integer.parseInt(request.getParameter("page"));
			String searchValue = "";
			if(request.getParameter("searchValue")!=null)
				searchValue = request.getParameter("searchValue");
//				String searchValue=tmp+"%";
				
			int rowCount = monSV.Count(searchValue);
			Paging p = new Paging(page, PAGE_SIZE, rowCount, searchValue);
			request.setAttribute("paging", p);
			request.setAttribute("list", monSV.GetList(page, PAGE_SIZE, searchValue));
			request.setAttribute("Account", tk);
			
//			List<Mon> m=monSV.GetAllMon();
//			modelMap.addAttribute("mon", m);
			
			return "Admin/Mon/ds-mon";
		}	
	}
	
	@GetMapping("create")
	public String create(@ModelAttribute Mon mon, ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}else {
			request.setAttribute("Account", tk);
			List<LoaiMon> lm=loaiMonSV.getAll();
			modelMap.addAttribute("loaiMon", lm);
			return "Admin/Mon/create";
		}
	}
	
	@PostMapping("create")
	public String confirmCreate(@ModelAttribute Mon mon) {
		monSV.CreateMon(mon);
		return "redirect:/admin/mon/list";
	}
	
	@GetMapping("delete/{id}")
	public String delete(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}else {
			request.setAttribute("Account", tk);
			Mon m=monSV.getMon(id);
			request.setAttribute("mon", m);
			return "Admin/Mon/delete";
		}
	}
	
	@GetMapping("delete/confirm/{id}")
	public String confirmDelete(HttpServletRequest request, @PathVariable("id") int id) {
		monSV.DeleteMon(id);
		return "redirect:/admin/mon/list";
	}
	
	@GetMapping("update/{id}")
	public String showFormEdit(HttpServletRequest request, @PathVariable("id") int id, HttpSession session) {
		String MaTK=(String)session.getAttribute("MaTK");
		String Pass = (String) session.getAttribute("Pass");
        TaiKhoan tk= taiKhoanSV.taiKhoan(MaTK, Pass);
		if(tk==null) {
			return "redirect:/admin/login";
		}else {
			request.setAttribute("Account", tk);
			Mon m = monSV.getMon(id);
			List<LoaiMon> lm=loaiMonSV.getAll();
			request.setAttribute("loaiMon", lm);
			request.setAttribute("mon", m);
			return "Admin/Mon/update";
		}
	}
	
	@PostMapping("update")
	public String Update(HttpServletRequest request, @ModelAttribute Mon mon) {
		monSV.UpdateMon(mon);
		return "redirect:/admin/mon/list";
	}
}
